package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PlanoServicoCompletoDTO extends PlanoServicoDTO implements Serializable {

    private PlanoDTO plano;

    private ServicoDTO servico;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanoServicoCompletoDTO{");
        sb.append(super.toString());
        sb.append("plano=").append(plano);
        sb.append(", servico=").append(servico);
        sb.append('}');
        return sb.toString();
    }
}
