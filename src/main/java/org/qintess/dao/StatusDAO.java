package org.qintess.dao;

import org.qintess.entity.Status;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StatusDAO {

    @Inject
    EntityManager em;

    public List<Status> getAll() {
        List<Object[]> list = em.createNativeQuery("SELECT NU_STATUS, CO_STATUS, NO_STATUS FROM STATUS ").getResultList();

        return list.stream()
                .map(this::mapearStatus)
                .collect(Collectors.toList());
    }

    private Status mapearStatus(Object[] objects) {
        Status status = new Status();

        BigDecimal id = (BigDecimal) objects[0];
        String codigo = objects[1].toString();
        String nome = objects[2].toString();

        status.setId(id.longValue());
        status.setCodigo(codigo);
        status.setNome(nome);
        return status;
    }
}
