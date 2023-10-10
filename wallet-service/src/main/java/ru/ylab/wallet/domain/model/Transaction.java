package ru.ylab.wallet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Транзакции это финансовую операцию пользователя.
 * Этот класс хранит информацию о пользователе, уникальном идентификаторе транзакции,
 * дате и времени транзакции и сумме денег в минимальных целых единицах.
 * Например, в копейках. Сумма положительная, значит пополнение, отрицательная списание.
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
        private UUID userId;
        private UUID transactionId;
        private OffsetDateTime transactionDate;
        private long amount;
}
