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

@Setter
@Getter
@Entity
@Table(name = "PLANO_PRODUTO", schema = "dbo")
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NU_PLANO_PRODUTO", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "NU_PRODUTO", nullable = false)
    private Long idProduto;

    @Size(max = 7)
    @NotNull
    @Column(name = "CO_PLANO_PRODUTO", length = 7, nullable = false)
    private String codigo;

    @Size(max = 40)
    @NotNull
    @Column(name = "NO_PLANO_PRODUTO", length = 40, nullable = false)
    private String nome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Plano{");
        sb.append("id=").append(id);
        sb.append(", idProduto=").append(idProduto);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
