/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Currency;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class CurrencyValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        return Currency.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object c, Errors errors) {
        Currency currency = (Currency) c;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "required.code", "El campo code es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "symbol", "required.code", "El campo simbolo es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description", "El campo description es obligatorio");
        
        //se comenta porque la fecha de creacion toma el dia del sistema
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creation_date","required.creation_date","El campo fecha creacion es obligatorio");
    }

}
