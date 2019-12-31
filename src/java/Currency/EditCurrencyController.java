
package Currency;


import DataBase.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
     @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Currency data = this.selectCurrency(id);
        mav.setViewName("currency/editCurrency");
        mav.addObject("currency", new Currency(data.getId(),data.getCode(), data.getSymbol(), data.getDescription(), data.getCreation_date()));
        return mav;
    }

    public Currency selectCurrency(int id) {
        final Currency currency = new Currency();
        String query = "SELECT * FROM Currency WHERE id='" + id + "'";
        return (Currency) jdbcTemplate.query(
                query, new ResultSetExtractor<Currency>() {
            public Currency extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    currency.setDescription(rs.getString("description"));
                    currency.setSymbol(rs.getString("symbol"));
                    currency.setCode(rs.getString("code"));
                    currency.setCreation_date(rs.getString("creation_date"));
                }
                return currency;
            }
        }
        );
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView putCountry(Model model,
            @ModelAttribute("currency") Currency m,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.currencyValidator.validate(m, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            Currency data = this.selectCurrency(id);
            mav.setViewName("currency/editCurrency");
            mav.addObject("currency", new Currency(id, data.getCode(), data.getSymbol(), data.getDescription(), data.getCreation_date()));
            return mav;

        } else {
            this.jdbcTemplate.update("UPDATE public.currency\n"
                    + "	SET description=?"
                    + "	WHERE id='" + id + "'", m.getDescription());
            return new ModelAndView("redirect:/currency.htm");
        }
    }
    
}
