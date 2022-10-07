package az.client.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ClientDto {

    private String name;
    private String surname;
    private BigDecimal wage;
    private LocalDateTime eventTime;

}
