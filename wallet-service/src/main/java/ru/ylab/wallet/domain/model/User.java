package ru.ylab.wallet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Зарегистрированных пользователи в системе.
 * Этот класс хранит информацию об уникальном идентификаторе пользователя, полном имени,
 * логине, пароле и текущем балансе на счету пользователя в минимальных единицах.
 * Каждая транзакция уменьшает или увеличивает это поле.
 * Баланс хранится для удобства и производительности.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    private UUID id;
    private String fullName;
    private String login;
    private String password;
    private long balance;
}
