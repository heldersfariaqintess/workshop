package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.PlanoServicoDTO;
import org.qintess.entity.PlanoServico;


@Mapper(componentModel = "cdi")
public interface PlanoServicoMapper extends EntityMapper<PlanoServicoDTO, PlanoServico> {

}
