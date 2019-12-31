
package Currency;

import DataBase.ConnectionDB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class DeleteCurrencyController {
     private JdbcTemplate jdbcTemplate;

    public DeleteCurrencyController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
    }
 @RequestMapping("deleteCurrency.htm")
 public ModelAndView deleteCurrency(HttpServletRequest request){
     int id= Integer.parseInt(request.getParameter("id"));
     this.jdbcTemplate.update("DELETE FROM currency where id=?",id);   
     return new ModelAndView("redirect:/currency.htm");
 }
}
