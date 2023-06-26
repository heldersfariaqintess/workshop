package org.qintess.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Setter
@Getter
@Entity
@Table(name = "CLIENTE", schema = "dbo")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NU_CLIENTE", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "NU_DOCUMENTO_CLIENTE", nullable = false)
    private BigInteger numeroDocumento;

    @Size(max = 200)
    @NotNull
    @Column(name = "NO_CLIENTE", length = 200, nullable = false)
    private String nome;

    @Column(name = "VR_RENDA_MENSAL")
    private Double rendaMensal;

    @NotNull
    @Column(name = "NU_CEP")
    private Integer cep;

    @Size(max = 53)
    @NotNull
    @Column(name = "DE_COMPLEMENTO_ENDERECO", length = 53, nullable = false)
    private String complementoEndereco;

    @Size(max = 40)
    @Column(name = "NO_LOGRADOURO", length = 40)
    private String logradouro;

    @Size(max = 35)
    @Column(name = "NO_MUNICIPIO", length = 35)
    private String municipio;

    @Size(max = 40)
    @Column(name = "NO_BAIRRO", length = 40)
    private String bairro;

    @Size(max = 2)
    @Column(name = "SG_UF", length = 2)
    private String uf;

    @Size(max = 10)
    @Column(name = "CO_NUMERO_ENDERECO", length = 10)
    private String numeroEndereco;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
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
