/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Departament;

import Departament.*;
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
@RequestMapping("editDepartament.htm")
public class EditDepartamentController {

    private JdbcTemplate jdbcTemplate;
    private DepartamentValidator departamentValidator;

    public EditDepartamentController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.departamentValidator = new DepartamentValidator();
    }

    @ModelAttribute("countryList")
    public List listarDepartamento() {
        List countryList = this.jdbcTemplate.queryForList("SELECT * FROM country");
        return countryList;
    }

    //recibir los datos y enviar al jsp editDepartament
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        Departament data = this.selectDepartament(id);
        mav.setViewName("editDepartament");
        mav.addObject("departament", new Departament(id, data.getCode(), data.getDescription(), data.getCountry_id(), data.getCreation_date()));
        return mav;

    }

    public Departament selectDepartament(int id) {
        final Departament departament = new Departament();
        String query = "SELECT * FROM departament WHERE id='" + id + "'";
        return (Departament) jdbcTemplate.query(
                query, new ResultSetExtractor<Departament>() {
            public Departament extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    departament.setCode(rs.getString("code"));
                    departament.setDescription(rs.getString("description"));
                    departament.setCountry_id(Integer.parseInt(rs.getString("country_id")));
                    departament.setCreation_date(rs.getString("creation_date"));
                }
                return departament;
            }
        }
        );
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView putDepartament(Model model,
            @ModelAttribute("departament") Departament c,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.departamentValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            Departament data = this.selectDepartament(id);
            mav.setViewName("editDepartament");
            mav.addObject("departament", new Departament(id, data.getCode(), data.getDescription(), data.getCountry_id(), data.getCreation_date()));
            return mav;

        } else {
            /*por el momento solo actualiza el code y la descripcion*/
            this.jdbcTemplate.update("UPDATE public.departament\n"
                    + "	SET code=?, description=?"
                    + "	WHERE id='" + id + "'", c.getCode(), c.getDescription());

            return new ModelAndView("redirect:/departament.htm");
        }
    }

}
