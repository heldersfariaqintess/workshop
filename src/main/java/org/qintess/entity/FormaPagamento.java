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
@Table(name = "FORMA_PAGAMENTO", schema = "dbo")
public class FormaPagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NU_FORMA_PAGAMENTO", nullable = false)
    private Long id;

    @Size(max = 30)
    @NotNull
    @Column(name = "NO_FORMA_PAGAMENTO", length = 30, nullable = false)
    private String nome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FormaPagamento{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
