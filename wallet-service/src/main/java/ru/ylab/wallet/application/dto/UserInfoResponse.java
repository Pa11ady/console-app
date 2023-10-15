package ru.ylab.wallet.application.dto;

/**
 * DTO класс ответ, который содержит информацию о пользователе в системе.
 * Информация о пользователе: полное имя,
 * логин и текущий баланс на его счете.
 */

public record UserInfoResponse(
        String fullName,
        String login,
        long balance
) {
}
