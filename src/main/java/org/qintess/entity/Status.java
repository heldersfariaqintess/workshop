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
@Table(name = "STATUS", schema = "dbo")
public class Status implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "NU_STATUS", nullable = false)
    private Long id;

    @Size(max = 3)
    @NotNull
    @Column(name = "CO_STATUS", length = 3, nullable = false)
    private String codigo;

    @Size(max = 50)
    @NotNull
    @Column(name = "NO_STATUS", length = 50, nullable = false)
    private String nome;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Status{");
        sb.append("id=").append(id);
        sb.append(", codigo='").append(codigo).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
