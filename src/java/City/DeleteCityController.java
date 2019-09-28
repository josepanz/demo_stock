
package City;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Panza
 */
public class DeleteCityController {
    private JdbcTemplate jdbcTemplate;

    public DeleteCityController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }
 @RequestMapping("deleteCity.htm")
 public ModelAndView deleteCity(HttpServletRequest request){
     int id= Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update("DELETE FROM city where id=?",id);   
     return new ModelAndView("redirect:/city.htm");
 }
 

}
