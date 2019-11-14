/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductPresentation;

import DataBase.ConnectionDB;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author NITRO 5
 */
public class ProductPresentationController {
    private JdbcTemplate jdbcTemplate;

    public ProductPresentationController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());       
    }
    
     @RequestMapping("productPresentation.htm")
        public ModelAndView productPresentation() {
        ModelAndView mav = new ModelAndView();
        List datos = this.jdbcTemplate.queryForList("SELECT * FROM produc_presentation");
        mav.addObject("datos", datos);
        mav.setViewName("productPresentation");
        return mav;
    }
        
      
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addProductPresentation() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("productPresentation", new ProductPresentation());
        mav.setViewName("addProductPresentation");
        return mav;
    }
 
    
}
