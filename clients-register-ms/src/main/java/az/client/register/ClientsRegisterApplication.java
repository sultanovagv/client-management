package az.client.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "az.client.register.client")
public class ClientsRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientsRegisterApplication.class, args);
    }


}
