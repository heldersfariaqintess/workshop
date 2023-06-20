package org.qintess.commons.exception;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

public class BadRequestQintessException extends QintessException implements StatusApiError {

    public BadRequestQintessException(String mensagem) {
        super(mensagem);
    }

    public BadRequestQintessException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }

    @Override
    public int getStatusCode() {
        return BAD_REQUEST.getStatusCode();
    }

    @Override
    public String getStatus() {
        return BAD_REQUEST.toString();
    }
}
