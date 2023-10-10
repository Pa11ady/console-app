package ru.ylab.wallet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Класс, представляющий событие для аудита.
 * Выбраны были простые id, чтобы не усложнять бизнес-логику тем более много
 * времени ушло на разработку гибкого консольного интерфейса.
 * Логин храним тоже как историю, на случай, если вдруг будет возможность
 * менять логины у пользователей и по логину удобнее смотреть администратору.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
        private UUID id;
        private EventType type;
        private UUID userId;
        private String userLogin;
        private OffsetDateTime eventDate;
        private String description;
}
