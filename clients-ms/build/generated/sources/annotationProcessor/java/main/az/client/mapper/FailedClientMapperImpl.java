package az.client.mapper;

import az.client.entity.FailedClientEntity;
import az.client.model.ClientDto;
import az.client.model.FailedClientDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-09T23:16:16+0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class FailedClientMapperImpl implements FailedClientMapper {

    @Override
    public FailedClientDto toFailedClientEntity(FailedClientEntity client) {
        if ( client == null ) {
            return null;
        }

        FailedClientDto failedClientDto = new FailedClientDto();

        failedClientDto.setId( client.getId() );
        failedClientDto.setName( client.getName() );
        failedClientDto.setSurname( client.getSurname() );
        failedClientDto.setWage( client.getWage() );
        failedClientDto.setEventTime( client.getEventTime() );
        failedClientDto.setActive( client.isActive() );

        return failedClientDto;
    }

    @Override
    public List<FailedClientDto> toFailedClientList(List<FailedClientEntity> client) {
        if ( client == null ) {
            return null;
        }

        List<FailedClientDto> list = new ArrayList<FailedClientDto>( client.size() );
        for ( FailedClientEntity failedClientEntity : client ) {
            list.add( toFailedClientEntity( failedClientEntity ) );
        }

        return list;
    }

    @Override
    public FailedClientEntity toFailedClient(ClientDto client) {
        if ( client == null ) {
            return null;
        }

        FailedClientEntity failedClientEntity = new FailedClientEntity();

        failedClientEntity.setName( client.getName() );
        failedClientEntity.setSurname( client.getSurname() );
        failedClientEntity.setWage( client.getWage() );
        failedClientEntity.setEventTime( client.getEventTime() );

        failedClientEntity.setActive( true );

        return failedClientEntity;
    }

    @Override
    public FailedClientEntity toFailedClientEntity(FailedClientDto client) {
        if ( client == null ) {
            return null;
        }

        FailedClientEntity failedClientEntity = new FailedClientEntity();

        failedClientEntity.setId( client.getId() );
        failedClientEntity.setName( client.getName() );
        failedClientEntity.setSurname( client.getSurname() );
        failedClientEntity.setWage( client.getWage() );
        failedClientEntity.setEventTime( client.getEventTime() );

        failedClientEntity.setActive( false );

        return failedClientEntity;
    }

    @Override
    public List<FailedClientEntity> toFailedClientEntityList(List<FailedClientDto> client) {
        if ( client == null ) {
            return null;
        }

        List<FailedClientEntity> list = new ArrayList<FailedClientEntity>( client.size() );
        for ( FailedClientDto failedClientDto : client ) {
            list.add( toFailedClientEntity( failedClientDto ) );
        }

        return list;
    }
}
