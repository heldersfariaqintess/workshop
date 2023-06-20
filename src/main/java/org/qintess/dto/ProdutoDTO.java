package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
public class ProdutoDTO implements Serializable {

    private Long id;

    @Size(max = 3)
    @NotNull
    private String codigo;

    @Size(max = 40)
    @NotNull
    private String nome;

    @Size(max = 100)
    private String descricao;

    private Double consumoMensalMinimo;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ProdutoDTO{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", consumoMensalMinimo=").append(consumoMensalMinimo);
        sb.append('}');
        return sb.toString();
    }
}