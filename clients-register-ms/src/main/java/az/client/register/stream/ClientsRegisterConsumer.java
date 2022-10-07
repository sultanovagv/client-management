package az.client.register.stream;

import az.client.register.model.ClientDto;
import az.client.register.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service("clients-register")
@RequiredArgsConstructor
@Slf4j
public class ClientsRegisterConsumer implements Consumer<Message<ClientDto>> {

    private final ClientService service;

    @Override
    public void accept(Message<ClientDto> message) {
        log.info("Message was received : {}", message.getPayload());
        service.saveClientInfo(message.getPayload());
    }

}
