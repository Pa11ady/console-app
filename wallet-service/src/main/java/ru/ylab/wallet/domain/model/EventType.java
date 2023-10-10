package ru.ylab.wallet.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
public enum EventType {
    LOGIN("Вход пользователя"),
    LOGOUT("Выход пользователя"),
    DEBIT("Списание"),
    CREDIT("Пополнение");

    private final String description;
}
