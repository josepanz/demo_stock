package AccessDenied;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AccessDeniedController {

    @RequestMapping("accessDenied.htm")
    public ModelAndView accesDenied() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("accessDenied");
        return mav;
    }
}
