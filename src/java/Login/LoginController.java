
package Login;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


public class LoginController {
    @RequestMapping("login.htm")
        public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
     
       // mav.addObject("datos",datos);
        mav.setViewName("login");
        return mav;
    }
        
        
}
