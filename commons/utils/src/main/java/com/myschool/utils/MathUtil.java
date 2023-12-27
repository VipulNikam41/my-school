package com.myschool.utils;

import lombok.experimental.UtilityClass;

import java.math.BigDecimal;

@UtilityClass
public class MathUtil {
    private static final BigDecimal zeroBigDecimal = new BigDecimal(0);

    public boolean isNegative(int a) {
        return a < 0;
    }

    public boolean isNegative(float a) {
        return a < 0;
    }

    public boolean isNegative(BigDecimal a) {
        return zeroBigDecimal.compareTo(a) < 0;
    }
}
