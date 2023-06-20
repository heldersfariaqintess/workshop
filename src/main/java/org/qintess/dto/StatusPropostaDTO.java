package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;


@Setter
@Getter
public class StatusPropostaDTO implements Serializable {

    @NotNull
    private Long idStatus;

    @NotNull
    private Long idProposta;

    @NotNull
    private LocalDateTime dataStatusProposta;

    @Size(max = 1000)
    private String comentario;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusPropostaDTO{");
        sb.append("idStatus=").append(idStatus);
        sb.append(", idProposta=").append(idProposta);
        sb.append(", dataStatusProposta=").append(dataStatusProposta);
        sb.append(", comentario='").append(comentario).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
