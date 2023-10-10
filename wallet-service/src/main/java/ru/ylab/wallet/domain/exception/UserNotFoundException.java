package ru.ylab.wallet.domain.exception;

/**
 * Исключение выбрасывается в случае, если такого пользователя нет.
 */

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        this("Пользователь не найден!");
    }
}
