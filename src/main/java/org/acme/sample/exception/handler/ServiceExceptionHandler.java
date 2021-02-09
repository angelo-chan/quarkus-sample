package org.acme.sample.exception.handler;

import lombok.extern.jbosslog.JBossLog;
import org.acme.sample.exception.base.InternalServerErrorException;
import org.acme.sample.exception.base.ServiceException;
import org.acme.sample.object.base.ErrorEntity;
import org.acme.sample.util.StackTraceSupport;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@JBossLog
@Provider
public class ServiceExceptionHandler implements ExceptionMapper<ServiceException> {

    @Inject
    StackTraceSupport stackTraceSupport;

    @Override
    public Response toResponse(ServiceException e) {
        ErrorEntity errorEntity = new ErrorEntity(e.getErrorCode(), e.getErrorMessage());
        if (e instanceof InternalServerErrorException) {
            log.error(e.getMessage(), e);
            if (stackTraceSupport.isShowStackTrace()) {
                errorEntity.setDevStackTrace(((InternalServerErrorException) e).getStackTraceString());
            }
        }
        return Response.status(e.getHttpStatus()).entity(errorEntity).type(MediaType.APPLICATION_JSON).build();
    }
}
