package az.client.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Client {

    @NotNull(message = "Name can't be null")
    private String name;
    @NotNull(message = "Surname can't be null")
    private String surname;
    @Min(value = 100, message = "Wage can't be lower")
    private BigDecimal wage;

}
