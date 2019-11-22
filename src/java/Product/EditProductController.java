/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Product;

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
@RequestMapping("editProduct.htm")
public class EditProductController {

    private JdbcTemplate jdbcTemplate;
    private ProductValidator productValidator;

    public EditProductController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.productValidator = new ProductValidator();
    }

    @ModelAttribute("measured_unitList")
    public List listarMeasured_unit() {
        List measured_unitList = this.jdbcTemplate.queryForList("SELECT * FROM measured_unit");
        return measured_unitList;
    }

    //recibir los datos y enviar al jsp editProduct
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Product data = this.selectProduct(id);
        mav.setViewName("product/editProduct");
        mav.addObject("product", new Product(id, data.getCode(), data.getDescription(),data.getAlternative_code(), data.getMeasured_unit_id(), data.getCreation_date()));
        return mav;

    }

    public Product selectProduct(int id) {
        final Product product = new Product();
        String query = "SELECT * FROM product WHERE id='" + id + "'";
        return (Product) jdbcTemplate.query(query, new ResultSetExtractor<Product>() {
            public Product extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    product.setCode(rs.getString("code"));
                    product.setDescription(rs.getString("description"));
                    product.setMeasured_unit_id(Integer.parseInt(rs.getString("measured_unit_id")));
                    product.setCreation_date(rs.getString("creation_date"));
                    product.setAlternative_code(rs.getString("alternative_code"));
                }
                return product;
            }
        }
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView putProduct(Model model,
            @ModelAttribute("product") Product c,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.productValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            Product data = this.selectProduct(id);
            mav.setViewName("product/editProduct");
            mav.addObject("product", new Product(id, data.getCode(), data.getDescription(), data.getAlternative_code(), data.getMeasured_unit_id(), data.getCreation_date()));
            return mav;

        } else {
            /*por el momento solo actualiza el code y la descripcion*/
            this.jdbcTemplate.update("UPDATE public.product\n"
                    + "	SET code=?, description=?,measured_unit_id=?, alternative_code=?"
                    + "	WHERE id='" + id + "'", c.getCode(), c.getDescription(),c.getMeasured_unit_id(), c.getAlternative_code());

            return new ModelAndView("redirect:/product.htm");
        }
    }

}
