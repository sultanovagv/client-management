package az.client.service;

import az.client.mapper.FailedClientMapper;
import az.client.model.ClientDto;
import az.client.model.FailedClientDto;
import az.client.repository.FailedClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FailedClientService {

    private final FailedClientRepository repository;
    private final FailedClientMapper mapper;

    public void saveFailedMessage(ClientDto client) {
        repository.save(mapper.toFailedClient(client));
    }

    public List<FailedClientDto> getFailedClients() {
        return mapper.toFailedClientList(repository.findByActiveTrue());
    }

    public void removeFailedClients(List<FailedClientDto> list) {
        repository.saveAll(mapper.toFailedClientEntityList(list));
    }

}
