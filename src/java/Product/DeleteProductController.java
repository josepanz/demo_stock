
package Product;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Panza
 */
public class DeleteProductController {
    private JdbcTemplate jdbcTemplate;

    public DeleteProductController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }
 @RequestMapping("deleteProduct.htm")
 public ModelAndView deleteProduct(HttpServletRequest request){
     int id= Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update("DELETE FROM product where id=?",id);   
     return new ModelAndView("redirect:/product.htm");
 }
 

}
