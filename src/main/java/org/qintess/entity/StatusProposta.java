package org.qintess.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;


@Setter
@Getter
@IdClass(StatusPropostaId.class)
@Entity
@Table(name = "STATUS_PROPOSTA", schema = "dbo")
public class StatusProposta implements Serializable {

    @Id
    @NotNull
    @Column(name = "NU_STATUS", nullable = false)
    private Long idStatus;

    @Id
    @NotNull
    @Column(name = "NU_PROPOSTA", nullable = false)
    private Long idProposta;

    @Id
    @NotNull
    @Column(name = "DH_STATUS_PROPOSTA", nullable = false)
    private LocalDateTime dataStatusProposta;

    @Size(max = 1000)
    @Column(name = "DE_COMENTARIO_STATUS_PROPOSTA", length = 1000)
    private String comentario;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusProposta{");
        sb.append("idStatus=").append(idStatus);
        sb.append(", idProposta=").append(idProposta);
        sb.append(", dataStatusProposta=").append(dataStatusProposta);
        sb.append(", comentario='").append(comentario).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
