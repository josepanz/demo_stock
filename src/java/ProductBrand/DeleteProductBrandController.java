package ProductBrand;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteProductBrandController {
    private JdbcTemplate jdbcTemplate;

    public DeleteProductBrandController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }
    @RequestMapping("deleteProductBrand.htm")
 public ModelAndView deleteProductFamily(HttpServletRequest request){
     int id= Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update("DELETE FROM product_brand where id=?",id);   
     return new ModelAndView("redirect:/productBrand.htm");
 }
}
