package org.qintess.dao.sql;

import lombok.Getter;
import lombok.Setter;
import org.qintess.dao.mapper.QueryMapper;

@Getter
@Setter
public class DadosQuery {

    private QueryMapper queryMapper;
    private String query;

    public DadosQuery(QueryMapper queryMapper, String query) {
        this.queryMapper = queryMapper;
        this.query = query;
    }
}
