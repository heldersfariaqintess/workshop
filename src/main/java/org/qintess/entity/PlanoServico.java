package org.qintess.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@IdClass(PlanoServicoId.class)
@Entity
@Table(name = "PLANO_SERVICO", schema = "dbo")
public class PlanoServico {

    @Id
    @NotNull
    @Column(name = "NU_PLANO_PRODUTO", nullable = false)
    private Long idPlano;

    @Id
    @NotNull
    @Column(name = "NU_SERVICO", nullable = false)
    private Long idServico;

    @Column(name = "VR_PLANO_SERVICO")
    private Double valor;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanoServico{");
        sb.append("idPlano=").append(idPlano);
        sb.append(", idServico=").append(idServico);
        sb.append(", valor=").append(valor);
        sb.append('}');
        return sb.toString();
    }
}
