package az.client.register.util;

import java.math.BigDecimal;
import java.math.RoundingMode;


public final class WageUtil {

    public static final BigDecimal HUNDRED = BigDecimal.valueOf(100);
    public static final int SCALE_RANGE_2 = 2;
    public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP;

    public static BigDecimal calculateWithTaxPercent(BigDecimal value, BigDecimal percent) {
        return value.multiply(percent).divide(HUNDRED, SCALE_RANGE_2, ROUNDING_MODE);
    }

}
