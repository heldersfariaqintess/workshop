package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.PropostaDTO;
import org.qintess.entity.Proposta;


@Mapper(componentModel = "cdi")
public interface PropostaMapper extends EntityMapper<PropostaDTO, Proposta> {

}
