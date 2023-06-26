package org.qintess.dao.sql;


import org.qintess.dao.mapper.FormaPagamentoQueryMapper;
import org.qintess.entity.FormaPagamento;
import org.qintess.utils.SqlUtils;

import static org.qintess.dao.sql.ContadorDeColunas.newInstanceContadorDeColunas;

public class FormaPagamentoSql {

    public static DadosQuery getByNome(String nome) {
        ContadorDeColunas contador = newInstanceContadorDeColunas();

        FormaPagamentoQueryMapper mapper = new FormaPagamentoQueryMapper();

        StringBuilder builder = new StringBuilder(" SELECT ");

        builder.append(" formaPagamento.NU_FORMA_PAGAMENTO, ");
        mapper.setIdMap(contador.contarIndex());

        builder.append(" formaPagamento.NO_FORMA_PAGAMENTO ");
        mapper.setNomeMap(contador.contarIndex());

        builder.append(" FROM ");
        builder.append(" dbo.FORMA_PAGAMENTO formaPagamento ");
        builder.append(" WHERE ");
        builder.append(" formaPagamento.NO_FORMA_PAGAMENTO ='").append(nome).append("'");

        return new DadosQuery(mapper, builder.toString());
    }

    public static DadosQuery getById(Long id) {

        ContadorDeColunas contador = newInstanceContadorDeColunas();

        FormaPagamentoQueryMapper mapper = new FormaPagamentoQueryMapper();

        StringBuilder builder = new StringBuilder(" SELECT ");

        builder.append(" formaPagamento.NU_FORMA_PAGAMENTO, ");
        mapper.setIdMap(contador.contarIndex());

        builder.append(" formaPagamento.NO_FORMA_PAGAMENTO ");
        mapper.setNomeMap(contador.contarIndex());

        builder.append(" FROM ");
        builder.append(" dbo.FORMA_PAGAMENTO formaPagamento ");
        builder.append(" WHERE ");
        builder.append(" formaPagamento.NU_FORMA_PAGAMENTO ='").append(id).append("'");

        return new DadosQuery(mapper, builder.toString());
    }

    public static DadosQuery getAll() {
        ContadorDeColunas contador = newInstanceContadorDeColunas();

        FormaPagamentoQueryMapper mapper = new FormaPagamentoQueryMapper();

        StringBuilder builder = new StringBuilder(" SELECT ");

        builder.append(" formaPagamento.NU_FORMA_PAGAMENTO, ");
        mapper.setIdMap(contador.contarIndex());

        builder.append(" formaPagamento.NO_FORMA_PAGAMENTO ");
        mapper.setNomeMap(contador.contarIndex());

        builder.append(" FROM ");
        builder.append(" dbo.FORMA_PAGAMENTO formaPagamento ");

        return new DadosQuery(mapper, builder.toString());
    }

    public static String insert(FormaPagamento formaPagamento) {
        StringBuilder builder = new StringBuilder();
        builder.append(" INSERT INTO dbo.FORMA_PAGAMENTO ( ");
        builder.append(" NO_FORMA_PAGAMENTO ");
        builder.append(" )VALUES( ");
        builder.append(SqlUtils.getStringSql(formaPagamento.getNome()));
        builder.append(")");
        return builder.toString();
    }

    public static String update(FormaPagamento formaPagamento) {
        StringBuilder builder = new StringBuilder();
        builder.append(" UPDATE dbo.FORMA_PAGAMENTO ");
        builder.append(" SET NO_FORMA_PAGAMENTO= ").append(SqlUtils.getStringSql(formaPagamento.getNome()));
        builder.append(" WHERE ");
        builder.append(" NU_FORMA_PAGAMENTO = ").append(formaPagamento.getId());
        return builder.toString();
    }

    public static String delete(Long id) {
        StringBuilder builder = new StringBuilder();
        builder.append(" delete from dbo.FORMA_PAGAMENTO ");
        builder.append(" WHERE ");
        builder.append(" NU_FORMA_PAGAMENTO = ").append(id);
        return builder.toString();
    }
}