package az.client.register.mapper;

import az.client.register.entity.ClientEntity;
import az.client.register.mapper.qualifier.WageQualifier;
import az.client.register.model.ClientDto;
import az.client.register.model.FailedClient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-06T23:04:30+0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Autowired
    private WageQualifier wageQualifier;

    @Override
    public ClientEntity toClientEntity(ClientDto dto) {
        if ( dto == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setWage( wageQualifier.mapWage( dto.getWage() ) );
        clientEntity.setName( dto.getName() );
        clientEntity.setSurname( dto.getSurname() );
        clientEntity.setEventTime( dto.getEventTime() );

        return clientEntity;
    }

    @Override
    public ClientEntity toClientEntity(FailedClient dto) {
        if ( dto == null ) {
            return null;
        }

        ClientEntity clientEntity = new ClientEntity();

        clientEntity.setWage( wageQualifier.mapWage( dto.getWage() ) );
        clientEntity.setId( dto.getId() );
        clientEntity.setName( dto.getName() );
        clientEntity.setSurname( dto.getSurname() );
        clientEntity.setEventTime( dto.getEventTime() );

        return clientEntity;
    }

    @Override
    public List<ClientEntity> toClientEntities(List<FailedClient> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ClientEntity> list = new ArrayList<ClientEntity>( dtos.size() );
        for ( FailedClient failedClient : dtos ) {
            list.add( toClientEntity( failedClient ) );
        }

        return list;
    }
}
