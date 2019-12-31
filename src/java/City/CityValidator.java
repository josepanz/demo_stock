
package City;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class CityValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
       return City.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object c, Errors errors) {
        City city = (City)c;    
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code","required.code","El campo code es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","required.description","El campo description es obligatorio");
        if(city.getDepartament_id()==0){
            errors.rejectValue("departament_id","required.departament_id", "Seleccione un departamento");
        }
        //se comenta porque la fecha de creacion toma el dia del sistema
         //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creation_date","required.creation_date","El campo fecha creacion es obligatorio");
    }
    
}
