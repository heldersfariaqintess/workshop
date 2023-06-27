package org.qintess.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.qintess.entity.Produto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@ApplicationScoped
public class ProdutoRepository implements PanacheRepository<Produto> {

    @Inject
    EntityManager em;

    public List<Produto> findAllJpql(List<Long> ids) {
        return em.createQuery("select p from Produto p where p.id in (:ids)", Produto.class)
                .setParameter("ids", ids)
                .getResultList();
    }

    public List<Produto> findAllJpql() {
        return em.createQuery("select p from Produto p ", Produto.class)
                .getResultList();
    }

    public Produto saveJpql(Produto entity) {
        em.persist(entity);
        return findByCodigoJpql(entity.getCodigo())
                .orElseThrow();
    }

    private Optional<Produto> findByCodigoJpql(String codigo) {

        try {
            return Optional.ofNullable(em.createQuery("SELECT p from Produto p where p.codigo = :codigo", Produto.class)
                    .setParameter("codigo", codigo)
                    .getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

}
