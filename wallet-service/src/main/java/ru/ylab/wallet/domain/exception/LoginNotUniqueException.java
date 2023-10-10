package ru.ylab.wallet.domain.exception;

/**
 * Исключение выбрасывается если логин пользователя не является уникальным.
 */

public class LoginNotUniqueException extends RuntimeException {
    public LoginNotUniqueException(String message) {
        super(message);
    }

    public LoginNotUniqueException() {
        this("Логин пользователя не уникальный!\n==Регистрация прервана!==");
    }
}
