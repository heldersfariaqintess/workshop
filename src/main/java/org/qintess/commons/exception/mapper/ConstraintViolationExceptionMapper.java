package org.qintess.commons.exception.mapper;


import org.jboss.logging.Logger;
import org.qintess.commons.exception.entity.ErrorApi;
import org.qintess.commons.exception.entity.FieldErrorApi;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.status;
import static org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    private static final Logger log = Logger.getLogger(ConstraintViolationExceptionMapper.class);

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        log.error(getStackTrace(exception));
        return status(BAD_REQUEST)
                .entity(ofConstraintViolation(exception))
                .build();
    }

    public static ErrorApi ofConstraintViolation(ConstraintViolationException exception) {
        List<FieldErrorApi> errosValidacao = new ArrayList<>();

        exception.getConstraintViolations()
                .forEach(violation -> errosValidacao.add(FieldErrorApi.of(violation)));

        ErrorApi errorApi = new ErrorApi();
        errorApi.setStatusCode(BAD_REQUEST.getStatusCode());
        errorApi.setStatus(BAD_REQUEST.toString());
        errorApi.setMessage("Corpo da mensagem não é válido.");
        errorApi.setErrosValidacao(errosValidacao);

        return errorApi;
    }
}
