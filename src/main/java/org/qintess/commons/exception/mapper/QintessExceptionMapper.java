package org.qintess.commons.exception.mapper;

import org.jboss.logging.Logger;
import org.qintess.commons.exception.QintessException;
import org.qintess.commons.exception.entity.ErrorApi;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.fromStatusCode;
import static javax.ws.rs.core.Response.status;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Provider
public class QintessExceptionMapper implements ExceptionMapper<QintessException> {

    private static final Logger log = Logger.getLogger(QintessExceptionMapper.class);

    @Override
    public Response toResponse(QintessException exception) {
        log.error(getStackTrace(exception));

        ErrorApi errorApi = new ErrorApi(
                exception.getStatusCode(),
                exception.getStatus(),
                exception.getMessage());

        return status(fromStatusCode(exception.getStatusCode()))
                .entity(errorApi)
                .build();
    }
}
