package Product;

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
public class ProductController {

    private JdbcTemplate jdbcTemplate;
    private ProductValidator productValidator;

    public ProductController() {
        ConnectionDB connect = new ConnectionDB();
        this.jdbcTemplate = new JdbcTemplate(connect.connection());
        this.productValidator = new ProductValidator();
    }

    @RequestMapping("product.htm")
    public ModelAndView product() {
        ModelAndView mav = new ModelAndView();
        List datos = this.jdbcTemplate.queryForList("SELECT c.id, c.code, c.description, d.description as measured_unit_id, c.creation_date FROM product c "
                + " join measured_unit d on d.id = c.measured_unit_id ");
        mav.addObject("datos", datos);
        mav.setViewName("product/product");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView addProduct() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("product", new Product());
        mav.setViewName("product/addProduct");
        // mav.addObject("mensaje",false);
        return mav;
    }

    @ModelAttribute("measured_unitList")
    public List listarMeasured_unit() {
        /*Aca bien podemos extraer datos de una base de datos, esto solo es un ejemplo*/
        List measured_unitList = this.jdbcTemplate.queryForList("SELECT * FROM measured_unit");

        /*aca si pillas como hacer que la clave sea el id, y el valor la descripcion,*/
        return measured_unitList;
    }

    //recibir y validar datos del formulario
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addProduct(Model model,
            @ModelAttribute("product") Product c,
            BindingResult result, SessionStatus status
    ) throws SQLException {
        this.productValidator.validate(c, result);
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView();
            mav.setViewName("product/addProduct");
            mav.addObject("product", new Product());
            return mav;
        } else {
            /* this.jdbcTemplate.update("UPDATE public.product\n"
                + "	SET  code=?,description=?\n"
                + "	WHERE id=1;", c.getCode(), c.getDescription());
             */
            this.jdbcTemplate.update("INSERT INTO public.product(\n"
                    + "	 code, description, measured_unit_id, alternative_code,creation_date)\n"
                    + "	VALUES ( upper(?), ?, ?, current_timestamp);", c.getCode(), c.getDescription(), c.getMeasured_unit_id(),c.getAlternative_code());
            ModelAndView mav = new ModelAndView();
            mav.setViewName("product/addProduct");
            model.addAttribute("product", new Product());//al formulario inicializamos con el contructor vacio, un objeto vacio
            mav.addObject("mensaje", "Insertado Correctamente");//mensaje  
            // return new ModelAndView("redirect:/formProduct.htm","mensaje","asdasdsad");//tambien de esta forma mas directa
            return mav;
        }
    }

}
