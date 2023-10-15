package ru.ylab.wallet.common;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Этот класс предоставляет утилиты для конвертации сумм в рублях и копейках.
 * Ну или центах в долларах в ТЗ не сказано. Чтобы не было потери точности и не накаливалась
 * ошибка в системе деньги хранятся в целых единицах.
 */

public class RubleConverter {
    public static long rublesToKopecks(String rubleAmount) {
        if (!rubleAmount.contains(".")) {
            rubleAmount += ".0";
        }
        BigDecimal rubles = new BigDecimal(rubleAmount);
        BigDecimal kopecks = rubles.multiply(new BigDecimal("100"));
        return kopecks.longValue();
    }

    public static String kopecksToRubles(long kopeckAmount) {
        return String.format(Locale.US, "%.2f", kopeckAmount / 100.0);
    }
}