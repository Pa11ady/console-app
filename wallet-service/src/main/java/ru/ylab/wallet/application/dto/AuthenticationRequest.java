package ru.ylab.wallet.application.dto;

/**
 * DTO класс для запроса на аутентификацию пользователя.
 * Он содержит информацию о логине и пароле пользователя.
 */

public record AuthenticationRequest(
        String login,
        String password) {
}
