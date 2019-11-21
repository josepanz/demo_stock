package MeasuredUnit;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MeasuredUnitValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return MeasuredUnit.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object c, Errors errors) {
        MeasuredUnit measuredUnit = (MeasuredUnit) c;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "required.description", "El campo description es obligatorio");
    }

}
