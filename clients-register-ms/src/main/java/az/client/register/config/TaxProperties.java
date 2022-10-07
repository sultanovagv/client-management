package az.client.register.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;

@Configuration
@Data
@ConfigurationProperties(prefix = "tax")
@PropertySource(value = "classpath:tax.yml", factory = YamlPropertySourceFactory.class)
public class TaxProperties {

    private BigDecimal percent;

}
