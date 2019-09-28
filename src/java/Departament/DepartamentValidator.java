
package Departament;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class DepartamentValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
       return Departament.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object d, Errors errors) {
        Departament departament = (Departament)d;    
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code","required.code","El campo code es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description","required.description","El campo description es obligatorio");
        if(departament.getCountry_id()==0){
            errors.rejectValue("country","required.country_id", "Seleccione un departamento");
        }
        //se comenta porque la fecha de creacion toma el dia del sistema
         //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creation_date","required.creation_date","El campo fecha creacion es obligatorio");
    }
    
}
