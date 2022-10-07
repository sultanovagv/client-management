package az.client.register.client;

import az.client.register.model.FailedClient;
import feign.Logger;
import feign.codec.ErrorDecoder;
import feign.error.AnnotationErrorDecoder;
import feign.jackson.JacksonDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(
        name = "clients-ms",
        url = "${client.clients-ms.url}",
        configuration = ClientsMsClient.FeignConfiguration.class,
        primary = false)
public interface ClientsMsClient {


    @GetMapping("/failed-clients")
    List<FailedClient> getFailedClients();

    @PostMapping("/failed-clients")
    void removeFailedClients(List<FailedClient> list);

    class FeignConfiguration {

        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }

        @Bean
        public ErrorDecoder feignErrorDecoder() {
            return AnnotationErrorDecoder.builderFor(ClientsMsClient.class)
                    .withResponseBodyDecoder(new JacksonDecoder())
                    .build();
        }

    }
}
