package az.client.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.containers.MySQLContainer;

@TestConfiguration
public class AbstractTestcontainers {

    private static final MySQLContainer<?> database = new MySQLContainer("mysql:latest")
            .withPassword("root")
            .withUsername("root");

    static {
        database.start();
        System.setProperty("spring.datasource.url", database.getJdbcUrl());
        System.setProperty("spring.datasource.password", database.getPassword());
        System.setProperty("spring.datasource.username", database.getUsername());
    }

}
