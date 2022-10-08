package az.client.register.service;

import az.client.register.client.ClientsMsClient;
import az.client.register.mapper.ClientRegisterMapper;
import az.client.register.model.ClientDto;
import az.client.register.model.FailedClient;
import az.client.register.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientRegisterService {

    private final ClientRepository repository;
    private final ClientRegisterMapper mapper;
    private final ClientsMsClient client;

    public void saveClientInfo(ClientDto client) {
        repository.save(mapper.toClientEntity(client));
    }

    public void removeFailedClients() {
        List<FailedClient> failedClients = client.getFailedClients();
        if (!CollectionUtils.isEmpty(failedClients)) {
            var clients = mapper.toClientEntities(failedClients);
            repository.saveAll(clients);
            client.removeFailedClients(failedClients);
        }
    }


}
