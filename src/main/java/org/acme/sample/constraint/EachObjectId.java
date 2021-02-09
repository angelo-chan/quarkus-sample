package org.acme.sample.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Check whether a valid mongo objectId collection. {@code null} collection are considered valid, but {@code null} element will be invalid.
 */
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EachObjectIdValidator.class)
@Documented
public @interface EachObjectId {

    String message() default "Invalid ObjectId";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
