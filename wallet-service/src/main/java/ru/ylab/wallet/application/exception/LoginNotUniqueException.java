package ru.ylab.wallet.application.exception;

public class LoginNotUniqueException extends RuntimeException {
    public LoginNotUniqueException(String message) {
        super(message);
    }

    public LoginNotUniqueException() {
        this("Логин пользователя не уникальный!\n==Регистрация прервана!==");
    }
}
