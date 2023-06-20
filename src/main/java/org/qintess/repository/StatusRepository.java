package org.qintess.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.qintess.dao.StatusDAO;
import org.qintess.entity.Status;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class StatusRepository  implements PanacheRepository<Status> {

    @Inject
    StatusDAO statusDAO;

    @Inject
    EntityManager em;

    public List<Status> findAllNative(){
        return statusDAO.getAll();
    }

    public List<Status> findAllJpql() {
      return em.createQuery("select s from Status s", Status.class).getResultList();
    }
}
