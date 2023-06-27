package org.qintess.commons.exception.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Getter
@Setter
public class ErrorApi implements Serializable {

    private String status;
    private Integer statusCode;
    private String message;

    @JsonInclude(NON_NULL)
    private String detail;

    @JsonInclude(NON_NULL)
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
