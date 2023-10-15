package ru.ylab.wallet.application.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * DTO класс ответ, который содержит информацию о транзакции в системе.
 * Транзакции включают в себя уникальный идентификатор, дату транзакции
 * и сумму транзакции.
 */

public record TransactionResponse(
        UUID transactionId,
        OffsetDateTime transactionDate,
        long amount
) {
}
