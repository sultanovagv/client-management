package az.client.service;

import az.client.entity.FailedClientEntity;
import az.client.mapper.ClientMapper;
import az.client.mapper.FailedClientMapper;
import az.client.model.Client;
import az.client.model.ClientDto;
import az.client.repository.FailedClientRepository;
import az.client.service.ClientService;
import az.client.service.FailedClientService;
import az.client.stream.ClientProducer;
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
public class ClientServiceTest {

    private FailedClientService failedClientService;
    @Mock
    private FailedClientRepository failedClientRepository;
    @Mock
    private FailedClientMapper failedClientMapper;

    @Mock
    private ClientProducer producer;
    @Mock
    private ClientMapper mapper;

    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        clientService = new ClientService(failedClientService, producer, mapper);
        failedClientService = new FailedClientService(failedClientRepository, failedClientMapper);
    }


    @Test
    void createClient_when_success() {
        var client = new Client();
        client.setName("Gunel");
        client.setSurname("Sultanova");
        client.setWage(new BigDecimal(1000));
        var clientDto = new ClientDto();
        clientDto.setName("Gunel");
        clientDto.setSurname("Sultanova");
        clientDto.setWage(new BigDecimal(1000));
        clientDto.setEventTime(LocalDateTime.now());

        when(mapper.toClientEntity(client)).thenReturn(clientDto);
        clientService.createClient(client);

        verify(mapper, times(1)).toClientEntity(client);
    }


    @Test
    void createClient_when_fail() {
        var clientDto = new ClientDto();
        clientDto.setName("Gunel");
        clientDto.setSurname("Sultanova");
        clientDto.setWage(new BigDecimal(1000));
        clientDto.setEventTime(LocalDateTime.now());

        var failed = new FailedClientEntity();
        failed.setName("Gunel");
        failed.setSurname("Sultanova");
        failed.setWage(new BigDecimal(1000));
        failed.setEventTime(LocalDateTime.now());

        when(failedClientMapper.toFailedClient(clientDto)).thenReturn(failed);
        when(failedClientRepository.save(failed)).thenReturn(failed);

        failedClientService.saveFailedMessage(clientDto);
    }


}
