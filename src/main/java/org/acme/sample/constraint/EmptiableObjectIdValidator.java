package org.acme.sample.constraint;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmptiableObjectIdValidator implements ConstraintValidator<EmptiableObjectId, String> {

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if (StringUtils.isEmpty(object)) {
            return true;
        }
        return org.bson.types.ObjectId.isValid(object);
    }
}
