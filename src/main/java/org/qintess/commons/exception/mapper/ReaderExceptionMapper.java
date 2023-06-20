package org.qintess.commons.exception.mapper;

import org.jboss.logging.Logger;
import org.jboss.resteasy.spi.ReaderException;
import org.qintess.commons.exception.entity.ErrorApi;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.status;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Provider
public class ReaderExceptionMapper implements ExceptionMapper<ReaderException> {

    private static final Logger log = Logger.getLogger(ReaderExceptionMapper.class);

    @Override
    public Response toResponse(ReaderException exception) {
        log.error(getStackTrace(exception));

        ErrorApi errorApi = new ErrorApi(BAD_REQUEST.getStatusCode(), BAD_REQUEST.toString(), exception.getMessage());

        return status(BAD_REQUEST)
                .entity(errorApi)
                .build();
    }
}
