package org.qintess.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


@Setter
@Getter
public class FormaPagamentoDTO implements Serializable {

    private Long id;

    @Size(max = 30)
    @NotNull
    private String nome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FormaPagamentoDTO{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
