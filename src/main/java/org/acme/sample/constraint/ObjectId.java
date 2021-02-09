package org.acme.sample.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Check whether a valid mongo objectId. {@code null} elements are considered valid.
 */
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ObjectIdValidator.class)
@Documented
public @interface ObjectId {

    String message() default "Invalid ObjectId";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
