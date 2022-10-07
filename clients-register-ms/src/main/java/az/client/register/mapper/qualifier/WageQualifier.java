package az.client.register.mapper.qualifier;

import az.client.register.config.TaxProperties;
import az.client.register.util.WageUtil;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class WageQualifier {

    private final TaxProperties taxProperties;

    @Named("mapWage")
    public BigDecimal mapWage(BigDecimal wage) {
        return WageUtil.calculateWithTaxPercent(wage, taxProperties.getPercent());
    }

}
