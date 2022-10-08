package az.client.register.mapper;

import az.client.register.entity.ClientEntity;
import az.client.register.mapper.qualifier.WageQualifier;
import az.client.register.model.ClientDto;
import az.client.register.model.FailedClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = WageQualifier.class, componentModel = "spring")
public interface ClientRegisterMapper {

    @Mapping(source = "wage", target = "wage", qualifiedByName = "mapWage")
    ClientEntity toClientEntity(ClientDto dto);

    @Mapping(source = "wage", target = "wage", qualifiedByName = "mapWage")
    ClientEntity toClientEntity(FailedClient dto);

    List<ClientEntity> toClientEntities(List<FailedClient> dtos);
}
