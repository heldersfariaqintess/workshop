package org.qintess.commons.exception.mapper;

import org.jboss.logging.Logger;
import org.qintess.commons.exception.entity.ErrorApi;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;
import static javax.ws.rs.core.Response.status;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

    private static final Logger log = Logger.getLogger(ApplicationExceptionMapper.class);

    @Override
    public Response toResponse(Exception exception) {
        log.error(getStackTrace(exception));

        ErrorApi errorApi = new ErrorApi(INTERNAL_SERVER_ERROR.getStatusCode(), INTERNAL_SERVER_ERROR.toString(), exception.getMessage());

        return status(INTERNAL_SERVER_ERROR)
                .entity(errorApi)
                .build();
    }
}
