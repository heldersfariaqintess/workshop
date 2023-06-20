package org.qintess.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
public class StatusPropostaId implements Serializable {

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusPropostaId{");
        sb.append("idStatus=").append(idStatus);
        sb.append(", idProposta=").append(idProposta);
        sb.append(", dataStatusProposta=").append(dataStatusProposta);
        sb.append('}');
        return sb.toString();
    }
}
