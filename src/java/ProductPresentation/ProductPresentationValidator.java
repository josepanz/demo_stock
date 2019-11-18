/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductPresentation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author NITRO 5
 */
public class ProductPresentationValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
       return ProductPresentation.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
       ProductPresentation productPresentatio = new ProductPresentation();
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentation_code","required.code","El campo code es obligatorio");
    }
    
}
