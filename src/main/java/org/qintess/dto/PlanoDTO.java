package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
public class PlanoDTO implements Serializable {

    private Long id;

    @NotNull
    private Long idProduto;

    @Size(max = 7)
    @NotNull
    private String codigo;

    @Size(max = 40)
    @NotNull
    private String nome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanoDTO{");
        sb.append("id=").append(id);
        sb.append(", idProduto=").append(idProduto);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
