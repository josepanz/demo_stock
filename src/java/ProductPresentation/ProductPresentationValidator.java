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
    public void validate(Object p, Errors errors) {
       ProductPresentation productPresentation = (ProductPresentation)p;
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentation_code","required.code","El campo Codigo es obligatorio");
       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "presentation_name","required.code","El campo Nombre de Presentacion es obligatorio");
       if(productPresentation.getProduct_family_id()==0){
           errors.rejectValue("product_family_id","required.product_family_id", "Seleccione una Familia de Producto");
       }
       if(productPresentation.getProduct_brand_id()==0){
           errors.rejectValue("product_brand_id","required.product_brand_id", "Seleccione una Marca de Producto");
       }
       if(productPresentation.getProduct_id()==0){
           errors.rejectValue("product_id","required.product_id", "Seleccione un Producto");
       }
    }
    
}
