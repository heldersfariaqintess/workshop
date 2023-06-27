package org.qintess.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.qintess.entity.Servico;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class ServicoRepository implements PanacheRepository<Servico> {

    @Inject
    EntityManager em;

    public List<Servico> findAllJpql() {
        return em.createQuery("select s from Servico s", Servico.class).getResultList();
    }

    public Servico saveJpql(Servico entity) {
        em.persist(entity);
        return findByCodigoJpql(entity.getCodigo())
                .orElseThrow();
    }

    public Optional<Servico> findByCodigoJpql(String codigo) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT s from Servico s where s.codigo = :codigo", Servico.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    public Optional<Servico> findByIdJpql(Long id) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT s from Servico s where s.id = :id", Servico.class)
                    .setParameter("id", id)
                    .getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    public List<Servico> findAllJpql(List<Long> ids) {
        return em.createQuery("select s from Servico s where s.id in (:ids)", Servico.class)
                .setParameter("ids", ids)
                .getResultList();

    }
}
