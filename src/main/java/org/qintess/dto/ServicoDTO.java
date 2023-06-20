package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
public class ServicoDTO implements Serializable {

    private Long id;

    @Size(max = 10)
    @NotNull
    private String codigo;

    @Size(max = 100)
    @NotNull
    private String nome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServicoDTO{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}