package ru.ylab.wallet.domain.exception;

/**
 * Исключение, которое выбрасывается когда идентификатор (ID)
 * является некорректным например null. Конечно можно было вообще
 * не проверять на null и программа сама где-нибудь падала бы, но
 * считается, что ошибки нужно отлавливаться как можно раньше и
 * чтобы исключение отличалось от стандартных исключений.
 */

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }

    public InvalidIdException() {
        this("Некорректный Id");
    }
}
