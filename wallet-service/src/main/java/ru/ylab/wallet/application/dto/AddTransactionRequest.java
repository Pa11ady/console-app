package ru.ylab.wallet.application.dto;

import java.util.UUID;

public record AddTransactionRequest(
        UUID userId,
        UUID transactionId,
        long amount
) {
}
