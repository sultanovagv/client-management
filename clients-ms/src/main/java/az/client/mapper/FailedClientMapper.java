package az.client.mapper;

import az.client.entity.FailedClientEntity;
import az.client.model.Client;
import az.client.model.ClientDto;
import az.client.model.FailedClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface FailedClientMapper {

    FailedClientDto toFailedClientEntity(FailedClientEntity client);

    List<FailedClientDto> toFailedClientList(List<FailedClientEntity> client);

    @Mapping(target = "active", expression = "java(true)")
    FailedClientEntity toFailedClient(ClientDto client);

    @Mapping(target = "active", expression = "java(false)")
    FailedClientEntity toFailedClientEntity(FailedClientDto client);

    List<FailedClientEntity> toFailedClientEntityList(List<FailedClientDto> client);

}