package org.qintess.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Setter
@Getter
public class ClienteDTO {

    private Long id;

    @NotNull
    private BigInteger numeroDocumento;

    @Size(max = 200)
    @NotNull
    private String nome;

    private Double rendaMensal;

    @NotNull
    private Integer cep;

    @Size(max = 53)
    @NotNull
    private String complementoEndereco;

    @Size(max = 40)
    private String logradouro;

    @Size(max = 35)
    private String municipio;

    @Size(max = 40)
    private String bairro;

    @Size(max = 2)
    private String uf;

    @Size(max = 10)
    private String numeroEndereco;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClienteDTO{");
        sb.append("id=").append(id);
        sb.append(", numeroDocumento=").append(numeroDocumento);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", rendaMensal=").append(rendaMensal);
        sb.append(", cep=").append(cep);
        sb.append(", complementoEndereco='").append(complementoEndereco).append('\'');
        sb.append(", logradouro='").append(logradouro).append('\'');
        sb.append(", municipio='").append(municipio).append('\'');
        sb.append(", bairro='").append(bairro).append('\'');
        sb.append(", uf='").append(uf).append('\'');
        sb.append(", numeroEndereco='").append(numeroEndereco).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
