package ru.ylab.wallet.infrastructure.in.ui;

import java.math.BigDecimal;

public class RubleConverter {
    public static long rublesToKopecks(String rubleAmount) {
        BigDecimal rubles = new BigDecimal(rubleAmount);
        BigDecimal kopecks = rubles.multiply(new BigDecimal("100"));
        return kopecks.longValue();
    }
}