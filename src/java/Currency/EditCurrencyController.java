
package Currency;


import DataBase.ConnectionDB;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("editCurrency.htm")
public class EditCurrencyController {
    private JdbcTemplate jdbcTemplate;
    private CurrencyValidator currencyValidator;
    
    public EditCurrencyController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.currencyValidator = new CurrencyValidator();
    } 
    
}
