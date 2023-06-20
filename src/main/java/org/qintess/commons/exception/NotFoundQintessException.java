package org.qintess.commons.exception;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

public class NotFoundQintessException extends QintessException implements StatusApiError {

    public NotFoundQintessException(String mensagem) {
        super(mensagem);
    }

    @Override
    public int getStatusCode() {
        return NOT_FOUND.getStatusCode();
    }

    @Override
    public String getStatus() {
        return NOT_FOUND.toString();
    }
}
