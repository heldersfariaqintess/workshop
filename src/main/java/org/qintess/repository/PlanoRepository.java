package org.qintess.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.qintess.entity.Plano;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class PlanoRepository implements PanacheRepository<Plano> {

    @Inject
    EntityManager em;

    public List<Plano> findAllJpql() {
        return em.createQuery("select plano from Plano plano", Plano.class).getResultList();
    }

    public Plano saveJpql(Plano entity) {
        em.persist(entity);
        return findByCodigoJpql(entity.getCodigo())
                .orElseThrow();
    }

    public Optional<Plano> findByCodigoJpql(String codigo) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT p from Plano p where p.codigo = :codigo", Plano.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }
}
