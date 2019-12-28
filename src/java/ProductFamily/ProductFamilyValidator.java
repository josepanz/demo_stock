
package ProductFamily;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ProductFamilyValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
       return ProductFamily.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object c, Errors errors) {
        ProductFamily productFamily= (ProductFamily)c;    
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code","required.code","El campo code es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","required.description","El campo description es obligatorio");
        
        //se comenta porque la fecha de creacion toma el dia del sistema
         //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creation_date","required.creation_date","El campo fecha creacion es obligatorio");
    }
    
}