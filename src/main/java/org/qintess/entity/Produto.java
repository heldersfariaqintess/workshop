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
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "PRODUTO", schema = "dbo")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NU_PRODUTO", nullable = false)
    private Long id;

    @Size(max = 3)
    @NotNull
    @Column(name = "CO_PRODUTO", length = 3, nullable = false)
    private String codigo;

    @Size(max = 40)
    @NotNull
    @Column(name = "NO_PRODUTO", length = 40, nullable = false)
    private String nome;

    @Size(max = 100)
    @Column(name = "DE_PRODUTO", length = 100)
    private String descricao;

    @Column(name = "VR_CONSUMO_MENSAL_ESTIMADO")
    private Double consumoMensalMinimo;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produto{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", descricao='").append(descricao).append('\'');
        sb.append(", consumoMensalMinimo=").append(consumoMensalMinimo);
        sb.append('}');
        return sb.toString();
    }
}