
package Departament;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Panza
 */
public class DeleteDepartamentController {
    private JdbcTemplate jdbcTemplate;

    public DeleteDepartamentController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }
 @RequestMapping("deleteDepartament.htm")
 public ModelAndView deleteDepartament(HttpServletRequest request){
     int id= Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update("DELETE FROM departament where id=?",id);   
     return new ModelAndView("redirect:/departament.htm");
 }
 

}
