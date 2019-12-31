
package Departament;

import DataBase.ConnectionDB;
import Departament.Departament;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
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
public class DepartamentController {
    private JdbcTemplate jdbcTemplate;
    private DepartamentValidator departamentValidator;
     public DepartamentController() {
        ConnectionDB connect = new ConnectionDB();      
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.departamentValidator = new DepartamentValidator();
    }
  
    
     @RequestMapping("departament.htm")
        public ModelAndView departament(){
        ModelAndView mav = new ModelAndView();
        String query = "SELECT d.id, d.code, d.description, c.description as country_id, c.creation_date FROM departament d "
                + " join country c on c.id = d.country_id ";
        List datos =this.jdbcTemplate.queryForList(query);
        mav.addObject("datos",datos);
        mav.setViewName("departament");
        return mav;
    }
    
     @RequestMapping(method=RequestMethod.GET)
     public ModelAndView addDepartament(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("departament",new Departament());
        mav.setViewName("addDepartament");
       // mav.addObject("mensaje",false);
        return mav;
    }
      @ModelAttribute("countryList")
    public List listarPais(){
        /*Aca bien podemos extraer datos de una base de datos, esto solo es un ejemplo*/
        List countryList = this.jdbcTemplate.queryForList("SELECT * FROM country");
        
      /*aca si pillas como hacer que la clave sea el id, y el valor la descripcion,*/
       return  countryList;
    }
   
    //recibir y validar datos del formulario
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView addDepartament
        (Model model,
        @ModelAttribute("departament") Departament d,
                BindingResult result, SessionStatus status 
        ) throws SQLException
    {
        this.departamentValidator.validate(d, result);
       if(result.hasErrors()){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addDepartament");
        mav.addObject("departament",new Departament());
        return mav;
       }else{
         /* this.jdbcTemplate.update("UPDATE public.city\n"
                + "	SET  code=?,description=?\n"
                + "	WHERE id=1;", c.getCode(), c.getDescription());
          */
          this.jdbcTemplate.update("INSERT INTO public.departament(\n" +
"	 code, description, country_id, creation_date)\n" +
"	VALUES ( ?, ?, ?, current_timestamp);",d.getCode(),d.getDescription(), d.getCountry_id());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addDepartament");
            model.addAttribute("departament",new Departament());//al formulario inicializamos con el contructor vacio, un objeto vacio
            mav.addObject("mensaje", "Insertado Correctamente");//mensaje  
     // return new ModelAndView("redirect:/formCity.htm","mensaje","asdasdsad");//tambien de esta forma mas directa
       return mav;
       }
    }
}
