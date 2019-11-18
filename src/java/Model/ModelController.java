package Model;

import DataBase.ConnectionDB;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

/**
 *
 * @author NITRO 5
 */
@Controller
public class ModelController {
        private JdbcTemplate jdbcTemplate;
        private ModelValidator modelValidator;

    public ModelController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.modelValidator = new ModelValidator();
    }
    @RequestMapping("model.htm")
    public ModelAndView model() {
        ModelAndView mav = new ModelAndView();
        List datos = this.jdbcTemplate.queryForList("select * from model ");
        mav.addObject("datos", datos);
        mav.setViewName("model/model");
        return mav;
    }    
      @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addModel() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("model", new Modell());
        mav.setViewName("model/addModel");
        return mav;
    }
     @ModelAttribute("brandList")
    public List listarMarca() {
        List brandList = this.jdbcTemplate.queryForList("SELECT * FROM product_Brand");
        return brandList;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addCity(Model model,
            @ModelAttribute("model") Modell m,
            BindingResult result, SessionStatus status
    ) throws SQLException {
        this.modelValidator.validate(m, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("model/addModel");
            mav.addObject("model", new Modell());
            return mav;
        } else {
            this.jdbcTemplate.update("INSERT INTO public.model(\n"
                    + "	 description,departament_id, year)\n"
                    + "	VALUES (?, ?, ?);", m.getDescripcion(), m.getBrand_id(), m.getYear());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("model/addModel");        
            model.addAttribute("model", new Modell());
            mav.addObject("mensaje", "Insertado Correctamente");
            return mav;
        }
    }
        
}
