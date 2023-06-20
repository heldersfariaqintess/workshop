package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class PlanoServicoDTO implements Serializable {

    @NotNull
    private Long idPlano;

    @NotNull
    private Long idServico;

    private Double valor;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanoServicoDTO{");
        sb.append("idPlano=").append(idPlano);
        sb.append(", idServico=").append(idServico);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }
}
