package org.acme.sample.exception.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.jbosslog.JBossLog;
import org.acme.sample.object.base.ErrorEntity;
import org.acme.sample.util.StackTraceSupport;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static org.acme.sample.util.ErrorCodes.BAD_REQUEST;

@JBossLog
@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Throwable> {

    @Inject
    StackTraceSupport stackTraceSupport;

    @Override
    public Response toResponse(Throwable e) {
        if (e instanceof JsonProcessingException | e instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorEntity(BAD_REQUEST, "错误请求", e.getMessage()))
                    .type(MediaType.APPLICATION_JSON).build();
        }
        log.error(e.getMessage(), e);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorEntity(stackTraceSupport.getStackTrace(e)))
                .type(MediaType.APPLICATION_JSON).build();

    }
}
