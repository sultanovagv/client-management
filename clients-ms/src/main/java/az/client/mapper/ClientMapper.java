package az.client.mapper;

import az.client.model.Client;
import az.client.model.ClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
         imports = LocalDateTime.class, componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "eventTime", expression = "java(LocalDateTime.now())")
    ClientDto toClientEntity(Client client);


}