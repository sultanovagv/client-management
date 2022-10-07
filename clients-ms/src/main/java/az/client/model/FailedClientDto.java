package az.client.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class FailedClientDto {

    private Long id;
    private String name;
    private String surname;
    private BigDecimal wage;
    private LocalDateTime eventTime;
    private Boolean active;
}
