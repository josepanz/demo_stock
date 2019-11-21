
package Country;

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
public class CountryController {
    private JdbcTemplate jdbcTemplate;
    private CountryValidator countryValidator;
     public CountryController() {
        ConnectionDB connect = new ConnectionDB();      
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.countryValidator = new CountryValidator();
    }
  
    
     @RequestMapping("country.htm")
        public ModelAndView country(){
        ModelAndView mav = new ModelAndView();
        String query = "SELECT c.id, c.code, c.description, c.creation_date FROM country c ";
        List datos =this.jdbcTemplate.queryForList(query);
        mav.addObject("datos",datos);
        mav.setViewName("country");
        return mav;
    }
    
     @RequestMapping(method=RequestMethod.GET)
     public ModelAndView addDepartament(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("country",new Country());
        mav.setViewName("addCountry");
       // mav.addObject("mensaje",false);
        return mav;
    }
     
   
    //recibir y validar datos del formulario
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView addCountry
        (Model model,
        @ModelAttribute("country") Country c,
                BindingResult result, SessionStatus status 
        ) throws SQLException
    {
        this.countryValidator.validate(c, result);
       if(result.hasErrors()){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addCountry");
        mav.addObject("country",new Country());
        return mav;
       }else{
         /* this.jdbcTemplate.update("UPDATE public.city\n"
                + "	SET  code=?,description=?\n"
                + "	WHERE id=1;", c.getCode(), c.getDescription());
          */
          this.jdbcTemplate.update("INSERT INTO public.country(\n" +
"	 code, description, creation_date)\n" +
"	VALUES ( upper(?), ?, current_timestamp);",c.getCode(),c.getDescription());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addCountry");
            model.addAttribute("country",new Country());//al formulario inicializamos con el contructor vacio, un objeto vacio
            mav.addObject("mensaje", "Insertado Correctamente");//mensaje  
     // return new ModelAndView("redirect:/formCity.htm","mensaje","asdasdsad");//tambien de esta forma mas directa
       return mav;
       }
    }
}
