package org.acme.sample.constraint;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

public class EachObjectIdValidator implements ConstraintValidator<EachObjectId, Collection<String>> {

    @Override
    public boolean isValid(Collection<String> collection, ConstraintValidatorContext constraintContext) {
        if (CollectionUtils.isEmpty(collection)) {
            return true;
        }
        boolean valid = true;
        for (String value : collection) {
            if (StringUtils.isEmpty(value)) {
                valid = false;
                break;
            } else if (!ObjectId.isValid(value)) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
