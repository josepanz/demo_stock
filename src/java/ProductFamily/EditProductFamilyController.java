/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductFamily;

import DataBase.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hitler
 */
@Controller
@RequestMapping("editProductFamily.htm")
public class EditProductFamilyController {

    private JdbcTemplate jdbcTemplate;
    private ProductFamilyValidator productFamilyValidator;

    public EditProductFamilyController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.productFamilyValidator = new ProductFamilyValidator();
    }

    //recibir los datos y enviar al jsp editProductFamily
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        ProductFamily data = this.selectProductFamily(id);
        mav.setViewName("editProductFamily");
        mav.addObject("productFamily", new ProductFamily(id, data.getCode(), data.getDescription(), data.getCreation_date(), data.isActive()));
        return mav;

    }

    public ProductFamily selectProductFamily(int id) {
        final ProductFamily productFamily = new ProductFamily();
        String query = "SELECT * FROM product_family WHERE id='" + id + "'";
        return (ProductFamily) jdbcTemplate.query(query, new ResultSetExtractor<ProductFamily>() {
            public ProductFamily extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    productFamily.setCode(rs.getString("code"));
                    productFamily.setDescription(rs.getString("name"));
                    productFamily.setCreation_date(rs.getString("creation_date"));
                }
                return productFamily;
            }
        }
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView putProductFamily(Model model,
            @ModelAttribute("productFamily") ProductFamily c,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.productFamilyValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            ProductFamily data = this.selectProductFamily(id);
            mav.setViewName("editProductFamily");
            mav.addObject("productFamily", new ProductFamily(id, data.getCode(), data.getDescription(), data.getCreation_date(), data.isActive()));
            return mav;

        } else {
            /*por el momento solo actualiza el code y la descripcion*/
            this.jdbcTemplate.update("UPDATE public.product_family\n"
                    + "	SET code=?, name=?"
                    + "	WHERE id='" + id + "'", c.getCode(), c.getDescription());

            return new ModelAndView("redirect:/productFamily.htm");
        }
    }

}
