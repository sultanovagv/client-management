package az.client.register.jobs;

import az.client.register.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RemoveFailedClientsJob {

    @Autowired
    private final ClientService clientService;

    @Scheduled(fixedRate = 30000, zone = "GMT+4")
    public void saveClients() {
        clientService.removeFailedClients();
        log.info(" clients is finished ");
    }
}
