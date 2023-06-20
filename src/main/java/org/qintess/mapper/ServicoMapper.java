package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.ServicoDTO;
import org.qintess.entity.Servico;


@Mapper(componentModel = "cdi")
public interface ServicoMapper extends EntityMapper<ServicoDTO, Servico> {

}
