
package Country;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Panza
 */
public class DeleteCountryController {
    private JdbcTemplate jdbcTemplate;

    public DeleteCountryController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }
 @RequestMapping("deleteCountry.htm")
 public ModelAndView deleteCountry(HttpServletRequest request){
     int id= Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update("DELETE FROM country where id=?",id);   
     return new ModelAndView("redirect:/country.htm");
 }
 

}
