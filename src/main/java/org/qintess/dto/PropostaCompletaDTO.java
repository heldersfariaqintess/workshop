package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PropostaCompletaDTO extends PropostaDTO implements Serializable {

    private ClienteDTO cliente;

    private PlanoDTO plano;

    private FormaPagamentoDTO formaPagamento;

    private StatusPropostaCompletoDTO ultimoStatus;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PropostaCompletaDTO{");
        sb.append(super.toString());
        sb.append("cliente=").append(cliente);
        sb.append(", plano=").append(plano);
        sb.append(", formaPagamento=").append(formaPagamento);
        sb.append(", ultimoStatus=").append(ultimoStatus);
        sb.append('}');
        return sb.toString();
    }
}