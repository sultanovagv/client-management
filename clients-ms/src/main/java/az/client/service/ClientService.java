package az.client.service;

import az.client.mapper.ClientMapper;
import az.client.model.Client;
import az.client.model.ClientDto;
import az.client.stream.ClientProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {

    private final FailedClientService failedClientService;
    private final ClientProducer producer;
    private final ClientMapper mapper;

    public void createClient(Client client) {
        ClientDto clientDto = mapper.toClientEntity(client);
        try {
            producer.produceMessages(clientDto);
            log.info("Message was sent : {}", client);
        } catch (Exception ex) {
            log.error("[Error occured: :{}]", ex);

            failedClientService.saveFailedMessage(clientDto);
        }

    }


}
