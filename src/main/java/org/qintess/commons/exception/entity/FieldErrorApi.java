package org.qintess.commons.exception.entity;

import lombok.Getter;
import lombok.Setter;

import javax.validation.ConstraintViolation;
import java.io.Serializable;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

@Getter
@Setter
public class FieldErrorApi implements Serializable {

    private final String atributo;

    private final String mensagem;

    private FieldErrorApi(ConstraintViolation<?> violation) {
        this.mensagem = violation.getMessage();
        this.atributo = Stream.of(violation.getPropertyPath().toString().split("\\.")).skip(2L).collect(joining("."));
    }

    public FieldErrorApi(String atributo, String mensagem) {
        this.mensagem = mensagem;
        this.atributo = atributo;
    }

    public static FieldErrorApi of(ConstraintViolation<?> violation) {
        return new FieldErrorApi(violation);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FieldError{");
        sb.append("atributo='").append(atributo).append('\'');
        sb.append(", mensagem='").append(mensagem).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
