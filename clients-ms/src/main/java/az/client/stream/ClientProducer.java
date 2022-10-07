package az.client.stream;

import az.client.model.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.MimeTypeUtils;

@Component
@RequiredArgsConstructor

public class ClientProducer {

    private static final String CLIENT_BINDING_NAME = "clients-register-out-0";

    private final StreamBridge streamBridge;

    public void produceMessages(ClientDto client) {
        Message<ClientDto> message = MessageBuilder.withPayload(client)
                .build();
        streamBridge.send(CLIENT_BINDING_NAME, message, MimeTypeUtils.APPLICATION_JSON);
    }

}
