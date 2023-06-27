package org.qintess.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.qintess.entity.PlanoServico;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class PlanoServicoRepository implements PanacheRepository<PlanoServico> {

    @Inject
    EntityManager em;

    public List<PlanoServico> findAllJpql() {
        return em.createQuery("select ps from PlanoServico ps", PlanoServico.class).getResultList();
    }

    public PlanoServico saveJpql(PlanoServico entity) {
        em.persist(entity);
        return findByIdPlanoIdServicoJpql(entity.getIdPlano(), entity.getIdServico())
                .orElseThrow();
    }

    public Optional<PlanoServico> findByIdPlanoIdServicoJpql(Long idPlano, Long idServico) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT ps from PlanoServico ps " +
                            " where ps.idPlano = :idPlano and ps.idServico = :idServico", PlanoServico.class)
                    .setParameter("idPlano", idPlano)
                    .setParameter("idServico", idServico)
                    .getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    public List<PlanoServico> findAllByIdPlanoJpql(List<Long> ids) {
        return em.createQuery("SELECT ps from PlanoServico ps where " +
                        " ps.idPlano in (:ids) ", PlanoServico.class)
                .setParameter("ids", ids)
                .getResultList();

    }
}
