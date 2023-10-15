package ru.ylab.wallet.application.exception;

/**
 * Исключение, которое выбрасывается
 * если на счете пользователя недостаточно средств, чтобы их снять.
 * Это одно из требований ТЗ.
 */

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException() {
        this("Недостаточно денег на счёте!\n==Транзакция прервана!==");
    }
}
