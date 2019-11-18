
package Login;


import java.security.Principal;
import javax.swing.JOptionPane;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


public class LoginController {
    @RequestMapping("login.htm")
        public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
     
       // mav.addObject("datos",datos);
        mav.setViewName("login");
        return mav;
    }
      /*  
     @RequestMapping(value = "/login.htm?error", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        JOptionPane.showMessageDialog(null, "llego al error");
        model.addAttribute("error", "true");
        return "login";

    }  */
     /*
     @RequestMapping("/index.htm")
    public ModelAndView hello(ModelMap model, Principal principal) {
        JOptionPane.showMessageDialog(null, "llego al index");
        String loggedInUserName = principal.getName();
        
        return new ModelAndView("index", "email", loggedInUserName);
    }*/
    
}
