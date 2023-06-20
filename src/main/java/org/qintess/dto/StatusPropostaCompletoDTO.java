package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
public class StatusPropostaCompletoDTO extends StatusPropostaDTO implements Serializable {

    private StatusDTO status;

    private PropostaDTO proposta;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StatusPropostaCompletoDTO{");
        sb.append(super.toString());
        sb.append("status=").append(status);
        sb.append(", proposta=").append(proposta);
        sb.append('}');
        return sb.toString();
    }
}
