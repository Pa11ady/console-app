package ru.ylab.wallet.application.dto;

import java.util.UUID;

/**
 * DTO класс для запроса о добавления нового пользователя.
 * Он содержит информацию о пользователе, такую как идентификатор,
 * полное имя, логин и пароль.
 */

public record AddUserRequest(
        UUID userId,
        String fullName,
        String login,
        String password) {
}
