package az.client.mapper;

import az.client.model.Client;
import az.client.model.ClientDto;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-09T23:56:47+0400",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto toClientEntity(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setName( client.getName() );
        clientDto.setSurname( client.getSurname() );
        clientDto.setWage( client.getWage() );

        clientDto.setEventTime( LocalDateTime.now() );

        return clientDto;
    }
}
