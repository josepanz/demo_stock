package Modelo;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author NITRO 5
 */
public class ModelValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
       return Modell.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object m, Errors errors) {
        Modell model = (Modell)m;
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code","required.code","El campo Descripcion es obligatorio");
         if(model.getBrand_id()==0){
            errors.rejectValue("brand_id","required.brand_id", "Seleccione una marca");
        }
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year","required.year","El campo Anho es obligatorio");
    }
    
}
