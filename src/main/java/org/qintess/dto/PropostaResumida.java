package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Getter
@Setter
public class PropostaResumida {

    private Long id;
    private BigInteger numeroDocumentoCliente;
    private String nomeStatusAtual;
    private LocalDateTime dataAtualizacaoStatusAtual;
}
