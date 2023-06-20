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
@Table(name = "SERVICO", schema = "dbo")
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NU_SERVICO", nullable = false)
    private Long id;

    @Size(max = 10 )
    @NotNull
    @Column(name = "CO_SERVICO", length = 10, nullable = false)
    private String codigo;

    @Size(max = 100)
    @NotNull
    @Column(name = "NO_SERVICO", length = 100, nullable = false)
    private String nome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Servico{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}