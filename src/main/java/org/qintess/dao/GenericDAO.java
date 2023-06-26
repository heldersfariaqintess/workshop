package org.qintess.dao;

import org.jboss.logging.Logger;
import org.qintess.commons.exception.QintessException;
import org.qintess.dao.sql.DadosQuery;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.jboss.logging.Logger.getLogger;

@Transactional
@ApplicationScoped
public class GenericDAO {

    private static final Logger log = getLogger(GenericDAO.class);

    @Inject
    EntityManager em;

    public void executeSql(String query) {
        try {
            em.createNativeQuery(query).executeUpdate();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new QintessException(e.getMessage(), e);
        }
    }

    public Optional<Object[]> get(DadosQuery dadosQuery) {
        return get(dadosQuery.getQuery());
    }

    public List<Object[]> list(DadosQuery dadosQuery) {
        return list(dadosQuery.getQuery());
    }

    public <T> Optional<T> get(String query) {
        try {
            return Optional.ofNullable((T) em.createNativeQuery(query).getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new QintessException(e.getMessage(), e);
        }
    }

    public <T> List<T> list(String query) {
        try {
            return (List<T>) em.createNativeQuery(query).getResultList();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new QintessException(e.getMessage(), e);
        }
    }
}