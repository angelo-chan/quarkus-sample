package org.acme.sample.constraint;

import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class EachNotNullValidator implements ConstraintValidator<EachNotNull, Collection> {

    @Override
    public boolean isValid(Collection collection, ConstraintValidatorContext constraintContext) {
        if (CollectionUtils.isEmpty(collection)) {
            return true;
        }
        boolean valid = true;
        for (Object element : collection) {
            if (element == null) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
