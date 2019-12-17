/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package City;

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
@RequestMapping("editCity.htm")
public class EditCityController {

    private JdbcTemplate jdbcTemplate;
    private CityValidator cityValidator;

    public EditCityController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.cityValidator = new CityValidator();
    }

    @ModelAttribute("departamentList")
    public List listarDepartamento() {
        List departamentList = this.jdbcTemplate.queryForList("SELECT * FROM departament");
        return departamentList;
    }

    //recibir los datos y enviar al jsp editCity
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        City data = this.selectCity(id);
        mav.setViewName("city/editCity");
        mav.addObject("city", new City(id, data.getCode(), data.getDescription(), data.getDepartament_id(), data.getCreation_date()));
        return mav;

    }

    public City selectCity(int id) {
        final City city = new City();
        String query = "SELECT * FROM city WHERE id='" + id + "'";
        return (City) jdbcTemplate.query(
                query, new ResultSetExtractor<City>() {
            public City extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    city.setCode(rs.getString("code"));
                    city.setDescription(rs.getString("description"));
                    city.setDepartament_id(Integer.parseInt(rs.getString("departament_id")));
                    city.setCreation_date(rs.getString("creation_date"));
                }
                return city;
            }
        }
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView putCity(Model model,
            @ModelAttribute("city") City c,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.cityValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            City data = this.selectCity(id);
            mav.setViewName("city/editCity");
            mav.addObject("city", new City(id, data.getCode(), data.getDescription(), data.getDepartament_id(), data.getCreation_date()));
            return mav;

        } else {
            /*por el momento solo actualiza el code y la descripcion*/
            this.jdbcTemplate.update("UPDATE public.city\n"
                    + "	SET code=?, description=?,departament_id=?"
                    + "	WHERE id='" + id + "'", c.getCode(), c.getDescription(),c.getDepartament_id());

            return new ModelAndView("redirect:/city.htm");
        }
    }

}
