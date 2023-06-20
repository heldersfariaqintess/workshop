package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.FormaPagamentoDTO;
import org.qintess.entity.FormaPagamento;


@Mapper(componentModel = "cdi")
public interface FormaPagamentoMapper extends EntityMapper<FormaPagamentoDTO, FormaPagamento> {

}
