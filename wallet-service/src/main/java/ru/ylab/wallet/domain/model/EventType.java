package ru.ylab.wallet.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Перечисление, представляющее типы событий в системе для аудита.
 * Используется при создании описания события.
 */

@RequiredArgsConstructor
@Getter
public enum EventType {
    LOGIN("Вход пользователя"),
    LOGOUT("Выход пользователя"),
    DEBIT("Списание"),
    CREDIT("Пополнение");

    private final String description;
}
