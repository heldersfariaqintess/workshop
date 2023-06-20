package org.qintess.commons.exception.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ErrorApi implements Serializable {

    private String status;
    private Integer statusCode;
    private String message;
    private String detail;
    private List<FieldErrorApi> errosValidacao;

    public ErrorApi() {
    }

    public ErrorApi(Integer statusCode, String status, String message) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorApi{");
        sb.append("status='").append(status).append('\'');
        sb.append(", statusCode=").append(statusCode);
        sb.append(", message='").append(message).append('\'');
        sb.append(", detail='").append(detail).append('\'');
        sb.append(", errosValidacao=").append(errosValidacao);
        sb.append('}');
        return sb.toString();
    }
}
