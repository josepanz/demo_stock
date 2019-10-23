/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Currency;

import City.City;
import DataBase.ConnectionDB;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Hitler
 */
public class CurrencyController {

    private JdbcTemplate jdbcTemplate;
    private CurrencyValidator currencyValidator;

    public CurrencyController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.currencyValidator = new CurrencyValidator();
    }

    @RequestMapping("currency.htm")
    public ModelAndView currency() {
        ModelAndView mav = new ModelAndView();
        List datos = this.jdbcTemplate.queryForList("SELECT * FROM currency");
        mav.addObject("datos", datos);
        mav.setViewName("currency");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addCurrency() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("currency", new Currency());
        mav.setViewName("addCurrency");
        return mav;
    }
    //recibir y validar datos del formulario

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addCurrency(Model model,
            @ModelAttribute("currency") Currency c,
            BindingResult result, SessionStatus status
    ) throws SQLException {
        this.currencyValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addCurrency");
            mav.addObject("currency", new City());
            return mav;
        } else {
            /* this.jdbcTemplate.update("UPDATE public.city\n"
                + "	SET  code=?,description=?\n"
                + "	WHERE id=1;", c.getCode(), c.getDescription());
             */
            this.jdbcTemplate.update("INSERT INTO public.currency(\n"
                    + "	 code, symbol, description, creation_date)\n"
                    + "	VALUES ( upper(?), ?, ?, current_timestamp);", c.getCode(), c.getDescription(), c.getSymbol());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addCurrency");
            model.addAttribute("currency", new Currency());//al formulario inicializamos con el contructor vacio, un objeto vacio
            mav.addObject("mensaje", "Insertado Correctamente");//mensaje  
            // return new ModelAndView("redirect:/formCity.htm","mensaje","asdasdsad");//tambien de esta forma mas directa
            return mav;
        }
    }

}
