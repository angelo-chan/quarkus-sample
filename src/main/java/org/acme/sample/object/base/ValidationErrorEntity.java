package org.acme.sample.object.base;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.acme.sample.util.ErrorCodes;

import java.util.List;

@Getter
@Setter
@RegisterForReflection
public class ValidationErrorEntity extends ErrorEntity {

    List<ConstraintViolationEntity> violations;

    public ValidationErrorEntity(List<ConstraintViolationEntity> violations) {
        super(ErrorCodes.VALIDATION_ERROR, "Validation Error");
        this.violations = violations;
    }
}
