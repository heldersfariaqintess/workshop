package org.qintess.dao;


import org.apache.commons.lang3.StringUtils;
import org.qintess.dao.mapper.FormaPagamentoQueryMapper;
import org.qintess.dao.mapper.QueryMapper;
import org.qintess.dao.sql.DadosQuery;
import org.qintess.dao.sql.FormaPagamentoSql;
import org.qintess.entity.FormaPagamento;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.qintess.dao.mapper.QueryMapper.mapLong;
import static org.qintess.dao.mapper.QueryMapper.mapString;

@Transactional
@ApplicationScoped
public class FormaPagamentoDAO {

    @Inject
    GenericDAO dao;

    public Optional<FormaPagamento> getByNome(String nome) {
        DadosQuery dadosQuery = FormaPagamentoSql.getByNome(nome);
        return dao.get(dadosQuery).map(linha -> mapearFormaPagamento(dadosQuery.getQueryMapper(), linha));
    }

    public List<FormaPagamento> getAll() {
        DadosQuery dadosQuery = FormaPagamentoSql.getAll();
        return dao.list(dadosQuery).stream()
                .map(linha -> mapearFormaPagamento(dadosQuery.getQueryMapper(), linha))
                .collect(toList());
    }

    public List<FormaPagamento> getAll(String nome) {
        if (StringUtils.isNotBlank(nome)) {
            return getByNome(nome)
                    .map(formaPagamento -> Stream.of(formaPagamento).collect(toList()))
                    .orElse(new LinkedList<>());
        }
        return getAll();
    }

    public Optional<FormaPagamento> getById(Long id) {
        DadosQuery dadosQuery = FormaPagamentoSql.getById(id);
        return dao.get(dadosQuery).map(linha -> mapearFormaPagamento(dadosQuery.getQueryMapper(), linha));
    }

    public void insert(FormaPagamento formaPagamento) {
        dao.executeSql(FormaPagamentoSql.insert(formaPagamento));
    }

    public void update(FormaPagamento formaPagamento) {
        dao.executeSql(FormaPagamentoSql.update(formaPagamento));
    }

    public void delete(Long id) {
        dao.executeSql(FormaPagamentoSql.delete(id));
    }

    public static FormaPagamento mapearFormaPagamento(QueryMapper queryMapper, Object[] linha) {
        FormaPagamento formaPagamento = null;
        if (queryMapper != null) {
            formaPagamento = new FormaPagamento();
            FormaPagamentoQueryMapper mapper = (FormaPagamentoQueryMapper) queryMapper;
            formaPagamento.setId(mapLong(linha, mapper.getIdMap()));
            formaPagamento.setNome(mapString(linha, mapper.getNomeMap()));
        }
        return formaPagamento;
    }
}
