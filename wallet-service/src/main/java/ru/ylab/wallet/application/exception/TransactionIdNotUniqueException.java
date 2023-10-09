package ru.ylab.wallet.application.exception;

public class TransactionIdNotUniqueException extends RuntimeException {
    public TransactionIdNotUniqueException(String message) {
        super(message);
    }

    public TransactionIdNotUniqueException() {
        this("Id транзакции не уникальный!\n==Транзакция прервана!==");
    }
}
