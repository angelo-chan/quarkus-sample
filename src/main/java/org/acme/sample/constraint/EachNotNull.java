package org.acme.sample.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Check not null for collection element. {@code null} collection are considered valid.
 */
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = EachNotNullValidator.class)
@Documented
public @interface EachNotNull {

    String message() default "Not Null for collection element";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
