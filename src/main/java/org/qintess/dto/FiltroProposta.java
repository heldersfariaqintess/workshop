package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Setter
@Getter
public class FiltroProposta implements Serializable {

    private Long idProduto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
}
