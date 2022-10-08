package az.client.register.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FailedClient {

    private Long id;
    private String name;
    private String surname;
    private BigDecimal wage;
    private LocalDateTime eventTime;
    private boolean active;
}
