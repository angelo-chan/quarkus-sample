package org.acme.sample.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ObjectIdValidator implements ConstraintValidator<ObjectId, String> {

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if (object == null) {
            return true;
        }
        return org.bson.types.ObjectId.isValid(object);
    }
}
