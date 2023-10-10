package ru.ylab.wallet.application.dto;

import java.time.OffsetDateTime;

/**
 * DTO класс ответа, который содержит информацию о событии (Аудит).
 * В описании события действия совершённые пользователем.
 */

public record EventResponse(
        String userLogin,
        OffsetDateTime eventDate,
        String description
) {
}
