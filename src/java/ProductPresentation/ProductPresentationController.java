/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductPresentation;

import DataBase.ConnectionDB;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NITRO 5
 */
public class ProductPresentationController {

    private JdbcTemplate jdbcTemplate;
    private ProductPresentationValidator productPresentationValidator;

    public ProductPresentationController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.productPresentationValidator = new ProductPresentationValidator();
    }

    @RequestMapping("productPresentation.htm")
    public ModelAndView productPresentation() {
        ModelAndView mav = new ModelAndView();
        List datos = this.jdbcTemplate.queryForList("SELECT * FROM produc_presentation");
        mav.addObject("datos", datos);
        mav.setViewName("productPresentation");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addProductPresentation() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("productPresentation", new ProductPresentation());
        mav.setViewName("addProductPresentation");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addProductPresentation(Model model,
            @ModelAttribute("productPresentation") ProductPresentation p,
            BindingResult result, SessionStatus status
    ) throws SQLException {
        this.productPresentationValidator.validate(p, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addProductPresentation");
            mav.addObject("productPresentation", new ProductPresentation());
            return mav;
        } else {
            this.jdbcTemplate.update("INSERT INTO public.product_presentation(\n"
                    + "	presentation_code, presentation_name, product_family_id, product_brand_id, product_id, creation_date, enabled, barcode, cost)\n"
                    + "	VALUES (upper(?), ?, ?, ?, ?,current_timestamp, ?, ?, ?);",
                    p.getPresentation_code(),
                    p.getPresentation_name(),
                    p.getProduct_family_id(),
                    p.getProduct_brand_id(),
                    p.getProduct_id(),
                    p.isEnable(),
                    p.getBarcode(),
                    p.getCost());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addProductPresentation");
            model.addAttribute("productPresentation", new ProductPresentation());
            mav.addObject("mensaje", "Insertado Correctamente");
            return mav;
        }
    }

    @ModelAttribute("familyList")
    public List listarFamiliaProducto() {
        List familyList = this.jdbcTemplate.queryForList("SELECT * FROM product_family");
        return familyList;
    }
    @ModelAttribute("brandList")
    public List listarMarcaProducto() {
        List brandList = this.jdbcTemplate.queryForList("SELECT * FROM product_brand");
        return brandList;
    }

}
