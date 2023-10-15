package ru.ylab.wallet.domain.exception;

/**
 * Исключение выбрасывается когда идентификатор (ID) транзакции не является уникальным.
 * Выбрал отдельно исключение, чтобы было заметно на фоне других исключений так как в ТЗ говорилась
 * конкретно про неуникальные транзакции. Также чтобы удобно было инкасулировать сообщение
 * об ошибки, которое пойдёт в консоль и не загромождать код сервисов и не выносить в отдельные
 * константы.
 */

public class TransactionIdNotUniqueException extends RuntimeException {
    public TransactionIdNotUniqueException(String message) {
        super(message);
    }

    public TransactionIdNotUniqueException() {
        this("Id транзакции не уникальный!\n==Транзакция прервана!==");
    }
}
