package service;

import az.client.register.client.ClientsMsClient;
import az.client.register.entity.ClientEntity;
import az.client.register.mapper.ClientRegisterMapper;
import az.client.register.model.ClientDto;
import az.client.register.repository.ClientRepository;
import az.client.register.service.ClientRegisterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientRegisterServiceTest {

    @Mock
    private ClientsMsClient clientsMsClient;
    @Mock
    private ClientRegisterMapper mapper;

    @Mock
    private ClientRepository repository;

    private ClientRegisterService clientRegisterService;

    @BeforeEach
    public void setUp() {
        clientRegisterService = new ClientRegisterService(repository, mapper, clientsMsClient);
    }


    @Test
    void saveClientInfo() {
        var client = new ClientEntity();
        client.setId(1000L);
        client.setName("Gunel");
        client.setSurname("Sultanova");
        client.setWage(new BigDecimal(1000));
        var clientDto = new ClientDto();
        clientDto.setName("Gunel");
        clientDto.setSurname("Sultanova");
        clientDto.setWage(new BigDecimal(1000));
        clientDto.setEventTime(LocalDateTime.now());

        when(mapper.toClientEntity(clientDto)).thenReturn(client);
        when(repository.save(client)).thenReturn(client);

        clientRegisterService.saveClientInfo(clientDto);

        verify(mapper, times(1)).toClientEntity(clientDto);
        verify(repository, times(1)).save(client);
    }


}
