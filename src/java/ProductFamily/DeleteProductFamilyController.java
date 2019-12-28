
package ProductFamily;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Panza
 */
public class DeleteProductFamilyController {
    private JdbcTemplate jdbcTemplate;

    public DeleteProductFamilyController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }
 @RequestMapping("deleteProductFamily.htm")
 public ModelAndView deleteProductFamily(HttpServletRequest request){
     int id= Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update("DELETE FROM product_family where id=?",id);   
     return new ModelAndView("redirect:/productFamily.htm");
 }
 

}
