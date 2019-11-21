/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeasuredUnit;

import Country.Country;
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
@RequestMapping("measuredUnit/editMeasuredUnit.ohtm")
public class EditMeasuredUnitController {

    private JdbcTemplate jdbcTemplate;
    private MeasuredUnitValidator measuredUnitValidator;

    public EditMeasuredUnitController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.measuredUnitValidator = new MeasuredUnitValidator();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        int id = Integer.parseInt(request.getParameter("id"));
        MeasuredUnit data = this.selectMeasuredUnit(id);
        mav.setViewName("measuredUnit/editMeasuredUnit");
        mav.addObject("measuredUnit", new MeasuredUnit(data.getId(), data.getDescription(), data.getCreation_date()));
        return mav;

    }

    public MeasuredUnit selectMeasuredUnit(int id) {
        final MeasuredUnit measuredUnit = new MeasuredUnit();
        String query = "SELECT * FROM measured_unit WHERE id='" + id + "'";
        return (MeasuredUnit) jdbcTemplate.query(
                query, new ResultSetExtractor<MeasuredUnit>() {
            public MeasuredUnit extractData(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    measuredUnit.setDescription(rs.getString("description"));
                    measuredUnit.setCreation_date(rs.getString("creation_date"));
                }
                return measuredUnit;
            }
        }
        );
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView putCountry(Model model,
            @ModelAttribute("measuredUnit") MeasuredUnit m,
            BindingResult result,
            SessionStatus status,
            HttpServletRequest request
    ) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        this.measuredUnitValidator.validate(m, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            MeasuredUnit data = this.selectMeasuredUnit(id);
            mav.setViewName("measuredUnit/editCountry");
            mav.addObject("measuredUnit", new MeasuredUnit(id, data.getDescription(),  data.getCreation_date()));
            return mav;

        } else {
            this.jdbcTemplate.update("UPDATE public.measured_unit\n"
                    + "	SET description=?"
                    + "	WHERE id='" + id + "'", m.getDescription());

            return new ModelAndView("redirect:/measuredUnit.htm");
        }
    }

}
