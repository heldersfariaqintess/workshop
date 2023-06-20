package org.qintess.mapper;


import org.mapstruct.Mapper;
import org.qintess.dto.StatusDTO;
import org.qintess.entity.Status;


@Mapper(componentModel = "cdi")
public interface StatusMapper extends EntityMapper<StatusDTO, Status> {

}
