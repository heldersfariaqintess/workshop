package org.qintess.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class PlanoCompletoDTO extends PlanoDTO implements Serializable {

    private ProdutoDTO produto;

    private List<PlanoServicoCompletoDTO> servicos;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlanoCompletoDTO{");
        sb.append(super.toString());
        sb.append("produto=").append(produto);
        sb.append(", servicos=").append(servicos);
        sb.append('}');
        return sb.toString();
    }
}
