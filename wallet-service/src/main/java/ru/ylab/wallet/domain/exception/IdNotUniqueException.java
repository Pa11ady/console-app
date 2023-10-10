package ru.ylab.wallet.domain.exception;

/**
 * Исключение, которое выбрасывается, если идентификатор (ID) не уникальный
 * пользователей и событий.
 */

public class IdNotUniqueException extends RuntimeException {
    public IdNotUniqueException(String message) {
        super(message);
    }

    public IdNotUniqueException() {
        this("Id не уникальный!");
    }
}
