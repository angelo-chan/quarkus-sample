package org.acme.sample.exception.handler;

import org.acme.sample.object.base.ConstraintViolationEntity;
import org.acme.sample.object.base.ValidationErrorEntity;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Provider
public class ConstraintViolationExceptionHandler implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException ex) {
        ValidationErrorEntity entity = new ValidationErrorEntity(ex.getConstraintViolations().stream().map(v ->
                new ConstraintViolationEntity(v.getPropertyPath().toString(),
                        v.getInvalidValue(), v.getMessage())).collect(Collectors.toList()));
        return Response.status(422).entity(entity).type(MediaType.APPLICATION_JSON).build();
    }
}
