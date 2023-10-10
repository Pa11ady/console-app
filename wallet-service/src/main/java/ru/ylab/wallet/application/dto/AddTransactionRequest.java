package ru.ylab.wallet.application.dto;

import java.util.UUID;

/**
 * DTO класс для запроса, чтобы создать транзакцию.
 * Он содержит информацию о пользователе, идентификаторе транзакции и сумме транзакции.
 */

public record AddTransactionRequest(
        UUID userId,
        UUID transactionId,
        long amount
) {
}
