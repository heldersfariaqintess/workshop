package org.qintess.commons.exception;

import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;

public class QintessException extends RuntimeException implements StatusApiError {

    public QintessException(String mensagem) {
        super(mensagem);
    }

    public QintessException(String mensagem, Throwable cause) {
        super(mensagem, cause);
    }

    @Override
    public int getStatusCode() {
        return INTERNAL_SERVER_ERROR.getStatusCode();
    }

    @Override
    public String getStatus() {
        return INTERNAL_SERVER_ERROR.toString();
    }
}
