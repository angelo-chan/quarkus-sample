package org.acme.sample.object.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConstraintViolationEntity {

    String propertyPath;

    Object invalidValue;

    String message;
}
