package ru.ylab.wallet.application.exception;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException(String message) {
        super(message);
    }

    public NotEnoughMoneyException() {
        this("Недостаточно денег на счёте!\n==Транзакция прервана!==");
    }
}
