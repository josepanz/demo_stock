
package ProductBrand;

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
public class ProductBrandController {
     private JdbcTemplate jdbcTemplate;
    private ProductBrandValidator productBrandValidator;

    public ProductBrandController() {
        ConnectionDB connect = new ConnectionDB();  
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.productBrandValidator = new ProductBrandValidator();
    }
    
    @RequestMapping("productBrand.htm")
          public ModelAndView productBrand(){
        ModelAndView mav = new ModelAndView();
        String query = "SELECT c.id, c.code, c.name, c.creation_date FROM product_brand c ";
        List datos =this.jdbcTemplate.queryForList(query);
        mav.addObject("datos",datos);
        mav.setViewName("productBrand");
        return mav;
    }
          
       @RequestMapping(method=RequestMethod.GET)
     public ModelAndView addProductBrand(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("productBrand",new ProductBrand());
        mav.setViewName("addProductBrand");
       // mav.addObject("mensaje",false);
        return mav;
    }
     @RequestMapping(method=RequestMethod.POST)
    public ModelAndView addProductFamily
        (Model model,
        @ModelAttribute("productBrand") ProductBrand p,
                BindingResult result, SessionStatus status 
        ) throws SQLException
    {
        this.productBrandValidator.validate(p, result);
       if(result.hasErrors()){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("addProductBrand");
        mav.addObject("productBrand",new ProductBrand());
        return mav;
       }else{
         /* this.jdbcTemplate.update("UPDATE public.city\n"
                + "	SET  code=?,description=?\n"
                + "	WHERE id=1;", c.getCode(), c.getDescription());
          */
          this.jdbcTemplate.update("INSERT INTO public.product_brand(\n" +
"	 code, name, creation_date, active)\n" +
"	VALUES ( upper(?), ?, current_timestamp, true);",p.getCode(),p.getName());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("addProductBrand");
            model.addAttribute("productBrand",new ProductBrand());//al formulario inicializamos con el contructor vacio, un objeto vacio
            mav.addObject("mensaje", "Insertado Correctamente");//mensaje  
     // return new ModelAndView("redirect:/formCity.htm","mensaje","asdasdsad");//tambien de esta forma mas directa
       return mav;
       }
    }
    
}
