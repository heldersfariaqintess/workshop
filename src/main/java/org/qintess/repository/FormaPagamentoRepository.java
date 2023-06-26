package org.qintess.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.qintess.dao.FormaPagamentoDAO;
import org.qintess.entity.FormaPagamento;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
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
     * JPQL sql
     */
    public List<FormaPagamento> findAllJpql() {
        return em.createQuery("select f from FormaPagamento f", FormaPagamento.class)
                .getResultList();
    }
}
