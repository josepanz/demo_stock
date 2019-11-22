
package Product;

import Product.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
       return Product.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object c, Errors errors) {
        Product product = (Product)c;    
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code","required.code","El campo code es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","required.description","El campo description es obligatorio");
        if(product.getMeasure_unit_id()==0){
            errors.rejectValue("measured_unit_id","required.measured_unit_id", "Seleccione un measured_unito");
        }
        //se comenta porque la fecha de creacion toma el dia del sistema al momento de insertar
         //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creation_date","required.creation_date","El campo fecha creacion es obligatorio");
    }
    
}
