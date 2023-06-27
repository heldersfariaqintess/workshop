package org.qintess.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
public class PlanoServicoId implements Serializable {

    @NotNull
    @Column(name = "NU_PLANO_PRODUTO", nullable = false)
    private Long idPlano;

    @NotNull
    @Column(name = "NU_SERVICO", nullable = false)
    private Long idServico;

    public PlanoServicoId() {
    }

    public PlanoServicoId(Long idPlano, Long idServico) {
        this.idPlano = idPlano;
        this.idServico = idServico;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanoServicoId{");
        sb.append("idPlano=").append(idPlano);
        sb.append(", idServico=").append(idServico);
        sb.append('}');
        return sb.toString();
    }
}
