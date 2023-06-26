package org.qintess.repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.qintess.dao.FormaPagamentoDAO;
import org.qintess.entity.FormaPagamento;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class FormaPagamentoRepository implements PanacheRepository<FormaPagamento> {

    @Inject
    FormaPagamentoDAO formaPagamentoDAO;

    @Inject
    EntityManager em;

    /**
     * Native sql
     */

    public List<FormaPagamento> findAllNative(String nome) {
        return formaPagamentoDAO.getAll(nome);
    }

    public Optional<FormaPagamento> findByIdNative(Long id) {
        return formaPagamentoDAO.getById(id);
    }

    public FormaPagamento saveNative(FormaPagamento formaPagamento) {
        formaPagamentoDAO.insert(formaPagamento);
        return formaPagamentoDAO.getByNome(formaPagamento.getNome()).get();
    }

    public FormaPagamento updateNative(FormaPagamento formaPagamento) {
        formaPagamentoDAO.update(formaPagamento);
        return formaPagamento;
    }

    public void deleteNative(Long id) {
        formaPagamentoDAO.delete(id);
    }

    /**
     * JPQL e HQL
     */
    public List<FormaPagamento> findAllJpql(String nome) {
        return em.createQuery("SELECT f from FormaPagamento f " +
                        " where (:nome is null) or (f.nome = :nome)", FormaPagamento.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public Optional<FormaPagamento> findByIdJpql(Long id) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT f from FormaPagamento f " +
                            " where f.id = :id", FormaPagamento.class)
                    .setParameter("id", id)
                    .getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    public FormaPagamento saveJpql(FormaPagamento entity) {
        em.persist(entity);
        return findByNomeJpql(entity.getNome())
                .orElseThrow();
    }

    public FormaPagamento updateJpql(FormaPagamento formaPagamento) {
        em.createQuery("update FormaPagamento set nome = :nome where id = :id")
                .setParameter("nome", formaPagamento.getNome())
                .setParameter("id", formaPagamento.getId())
                .executeUpdate();
        return formaPagamento;
    }

    public void deleteJpql(Long id) {
        em.createQuery("delete FormaPagamento where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Optional<FormaPagamento> findByNomeJpql(String nome) {
        try {
            return Optional.ofNullable(em.createQuery("SELECT f from FormaPagamento f " +
                            " where :nome is null or f.nome = :nome", FormaPagamento.class)
                    .setParameter("nome", nome)
                    .getSingleResult());
        } catch (NoResultException noResultException) {
            return Optional.empty();
        }
    }

    /**
     * PANACHE FRAMEWORK
     * https://quarkus.io/guides/hibernate-orm-panache
     */

    public FormaPagamento update(FormaPagamento formaPagamento) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", formaPagamento.getId());
        parameters.put("nome", formaPagamento.getNome());

        update("nome = :nome where id = :id", parameters);

        return formaPagamento;
    }

    public PanacheQuery<FormaPagamento> findAll(String nome) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nome", nome);
        return find("(:nome is null) or (nome = :nome)", parameters);
    }
}