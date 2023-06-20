package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.StatusPropostaDTO;
import org.qintess.entity.StatusProposta;


@Mapper(componentModel = "cdi")
public interface StatusPropostaMapper extends EntityMapper<StatusPropostaDTO, StatusProposta> {

}
