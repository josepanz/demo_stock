
package ProductBrand;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ProductBrandValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return ProductBrand.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ProductBrand productBrand = new ProductBrand();
         ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code","required.code","El campo code es obligatorio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","required.name","El campo nombre es obligatorio");
    }
    
}
