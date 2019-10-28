package ProductBrand;

import DataBase.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("editProductBrand.htm")
public class EditProductBrandController {

    private JdbcTemplate jdbcTemplate;
    private ProductBrandValidator productBrandValidator;

    public EditProductBrandController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.productBrandValidator = new ProductBrandValidator();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        ProductBrand data = this.selectProductBrand(id);
        mav.setViewName("editProductBrand");
        mav.addObject("productBrand", new ProductBrand(id, data.getCode(), data.getName(), data.isActive(), data.getCreation_date()));
        return mav;

    }

    public ProductBrand selectProductBrand(int id) {
        final ProductBrand productBrand = new ProductBrand();
        String query = "SELECT * FROM product_brand WHERE id='" + id + "'";
        return (ProductBrand) jdbcTemplate.query(query, new ResultSetExtractor<ProductBrand>() {
            public ProductBrand extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    productBrand.setCode(rs.getString("code"));
                    productBrand.setName(rs.getString("name"));
                    productBrand.setCreation_date(rs.getString("creation_date"));
                }
                return productBrand;
            }
        }
        );
    }

}
