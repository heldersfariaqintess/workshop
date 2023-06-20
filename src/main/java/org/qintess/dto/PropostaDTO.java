package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class PropostaDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NU_PROPOSTA", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "NU_CLIENTE", nullable = false)
    private Long idCliente;

    @NotNull
    @Column(name = "NU_PLANO_PRODUTO", nullable = false)
    private Long idPlano;

    @NotNull
    @Column(name = "NU_FORMA_PAGAMENTO", nullable = false)
    private Long idFormaPagamento;

    @NotNull
    @Column(name = "QT_PRODUTO", nullable = false)
    private Integer quantidadeProduto;

    @NotNull
    @Column(name = "DD_DIA_VENCIMENTO", nullable = false)
    private Integer diaVencimento;

    @Size(max = 50)
    @Column(name = "CO_PROTOCOLO_PROPOSTA", length = 50)
    private String codigoProtocoloProposta;

    @NotNull
    @Column(name = "DT_CRIACAO_PROPOSTA", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "DT_EXPIRACAO_PROPOSTA")
    private LocalDateTime dataExpiracao;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PropostaDTO{");
        sb.append("id=").append(id);
        sb.append(", idCliente=").append(idCliente);
        sb.append(", idPlano=").append(idPlano);
        sb.append(", idFormaPagamento=").append(idFormaPagamento);
        sb.append(", quantidadeProduto=").append(quantidadeProduto);
        sb.append(", diaVencimento=").append(diaVencimento);
        sb.append(", codigoProtocoloProposta='").append(codigoProtocoloProposta).append('\'');
        sb.append(", dataCriacao=").append(dataCriacao);
        sb.append(", dataExpiracao=").append(dataExpiracao);
        sb.append('}');
        return sb.toString();
    }
}