package City;
import DataBase.ConnectionDB;
import Departament.Departament;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {

    private JdbcTemplate jdbcTemplate;
    private CityValidator cityValidator;

    public CityController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.cityValidator = new CityValidator();
    }

    @RequestMapping("city.htm")
    public ModelAndView city() {
        ModelAndView mav = new ModelAndView();
        List datos = this.jdbcTemplate.queryForList("SELECT c.id, c.code, c.description, d.description as departament_id, c.creation_date FROM city c "
                + " join departament d on d.id = c.departament_id ");
        mav.addObject("datos", datos);
        mav.setViewName("city");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addCity() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("city", new City());
        mav.setViewName("addCity");
        // mav.addObject("mensaje",false);
        return mav;
    }

    @ModelAttribute("departamentList")
    public List listarDepartamento() {
        /*Aca bien podemos extraer datos de una base de datos, esto solo es un ejemplo*/
        List departamentList = this.jdbcTemplate.queryForList("SELECT * FROM departament");

        /*aca si pillas como hacer que la clave sea el id, y el valor la descripcion,*/
        return departamentList;
    }

    //recibir y validar datos del formulario
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addCity(Model model,
            @ModelAttribute("city") City c,
            BindingResult result, SessionStatus status
    ) throws SQLException {
        this.cityValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addCity");
            mav.addObject("city", new City());
            return mav;
        } else {
            /* this.jdbcTemplate.update("UPDATE public.city\n"
                + "	SET  code=?,description=?\n"
                + "	WHERE id=1;", c.getCode(), c.getDescription());
             */
            this.jdbcTemplate.update("INSERT INTO public.city(\n"
                    + "	 code, description, departament_id, creation_date)\n"
                    + "	VALUES ( upper(?), ?, ?, current_timestamp);", c.getCode(), c.getDescription(), c.getDepartament_id());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addCity");
            model.addAttribute("city", new City());//al formulario inicializamos con el contructor vacio, un objeto vacio
            mav.addObject("mensaje", "Insertado Correctamente");//mensaje  
            // return new ModelAndView("redirect:/formCity.htm","mensaje","asdasdsad");//tambien de esta forma mas directa
            return mav;
        }
    }

}
