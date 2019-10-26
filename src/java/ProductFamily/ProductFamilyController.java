
package ProductFamily;

import DataBase.ConnectionDB;
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

import org.springframework.web.servlet.ModelAndView;import java.sql.SQLException;
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
public class ProductFamilyController {
    private JdbcTemplate jdbcTemplate;
    private ProductFamilyValidator productFamilyValidator;
     public ProductFamilyController() {
        ConnectionDB connect = new ConnectionDB();      
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.productFamilyValidator = new ProductFamilyValidator();
    }
  
    
     @RequestMapping("productFamily.htm")
        public ModelAndView productFamily(){
        ModelAndView mav = new ModelAndView();
        String query = "SELECT c.id, c.code, c.description, c.creation_date FROM product_family c ";
        List datos =this.jdbcTemplate.queryForList(query);
        mav.addObject("datos",datos);
        mav.setViewName("productFamily");
        return mav;
    }
    
     @RequestMapping(method=RequestMethod.GET)
     public ModelAndView addProductFamily(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("productFamily",new ProductFamily());
        mav.setViewName("addProductFamily");
       // mav.addObject("mensaje",false);
        return mav;
    }
     
   
    //recibir y validar datos del formulario
    @RequestMapping(method=RequestMethod.POST)
    public ModelAndView addProductFamily
        (Model model,
        @ModelAttribute("productFamily") ProductFamily c,
                BindingResult result, SessionStatus status 
        ) throws SQLException
    {
        this.productFamilyValidator.validate(c, result);
       if(result.hasErrors()){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addProductFamily");
        mav.addObject("productFamily",new ProductFamily());
        return mav;
       }else{
         /* this.jdbcTemplate.update("UPDATE public.city\n"
                + "	SET  code=?,description=?\n"
                + "	WHERE id=1;", c.getCode(), c.getDescription());
          */
          this.jdbcTemplate.update("INSERT INTO public.product_family(\n" +
"	 code, description, creation_date)\n" +
"	VALUES ( upper(?), ?, current_timestamp);",c.getCode(),c.getDescription());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addProductFamily");
            model.addAttribute("productFamily",new ProductFamily());//al formulario inicializamos con el contructor vacio, un objeto vacio
            mav.addObject("mensaje", "Insertado Correctamente");//mensaje  
     // return new ModelAndView("redirect:/formCity.htm","mensaje","asdasdsad");//tambien de esta forma mas directa
       return mav;
       }
    }
}
