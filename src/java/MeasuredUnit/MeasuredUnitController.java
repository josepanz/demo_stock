package MeasuredUnit;

import DataBase.ConnectionDB;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeasuredUnitController {

    private JdbcTemplate jdbcTemplate;
    private MeasuredUnitValidator measuredUnitValidator;

    public MeasuredUnitController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.measuredUnitValidator = new MeasuredUnitValidator();
    }

    @RequestMapping("measuredUnit.htm")
    public ModelAndView measuredUnit() {
        ModelAndView mav = new ModelAndView();
        String query = "SELECT * from measured_unit ";
        List datos = this.jdbcTemplate.queryForList(query);
        mav.addObject("datos", datos);
        mav.setViewName("measuredUnit/measuredUnit");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addDepartament() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("measuredUnit", new MeasuredUnit());
        mav.setViewName("measuredUnit/addMeasuredUnit");
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addCountry(Model model,
            @ModelAttribute("measuredUnit") MeasuredUnit m,
            BindingResult result, SessionStatus status
    ) throws SQLException {
        this.measuredUnitValidator.validate(m, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("measuredUnit/addMeasuredUnit");
            mav.addObject("measuredUnit", new MeasuredUnit());
            return mav;
        } else {
            this.jdbcTemplate.update("INSERT INTO public.measured_unit(\n"
                    + "	  description, creation_date)\n"
                    + "	VALUES ( ?, current_timestamp);", m.getDescription());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("measuredUnit/addMeasuredUnit");
            model.addAttribute("measuredUnit/measuredUnit", new MeasuredUnit());
            mav.addObject("mensaje", "Insertado Correctamente");
            return mav;
        }
    }
}
