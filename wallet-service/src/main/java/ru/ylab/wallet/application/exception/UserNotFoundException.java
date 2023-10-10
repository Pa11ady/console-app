package ru.ylab.wallet.application.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException() {
        this("Пользователь не найден!");
    }
}
