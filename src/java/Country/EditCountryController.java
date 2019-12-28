/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Country;

import DataBase.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
@RequestMapping("editCountry.htm")
public class EditCountryController {

    private JdbcTemplate jdbcTemplate;
    private CountryValidator countryValidator;

    public EditCountryController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.countryValidator = new CountryValidator();
    }

   

    //recibir los datos y enviar al jsp editCountry
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Country data = this.selectCountry(id);
        mav.setViewName("editCountry");
        mav.addObject("country", new Country(id, data.getCode(), data.getDescription(),  data.getCreation_date()));
        return mav;

    }

    public Country selectCountry(int id) {
        final Country country = new Country();
        String query = "SELECT * FROM country WHERE id='" + id + "'";
        return (Country) jdbcTemplate.query(
                query, new ResultSetExtractor<Country>() {
            public Country extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    country.setCode(rs.getString("code"));
                    country.setDescription(rs.getString("description"));
                    country.setCreation_date(rs.getString("creation_date"));
                }
                return country;
            }
        }
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView putCountry(Model model,
            @ModelAttribute("country") Country c,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.countryValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            Country data = this.selectCountry(id);
            mav.setViewName("editCountry");
            mav.addObject("country", new Country(id, data.getCode(), data.getDescription(),  data.getCreation_date()));
            return mav;

        } else {
            /*por el momento solo actualiza el code y la descripcion*/
            this.jdbcTemplate.update("UPDATE public.country\n"
                    + "	SET code=?, description=?"
                    + "	WHERE id='" + id + "'", c.getCode(), c.getDescription());

            return new ModelAndView("redirect:/country.htm");
        }
    }

}
