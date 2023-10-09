package ru.ylab.wallet.application.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public record TransactionResponse(
        UUID transactionId,
        OffsetDateTime transactionDate,
        long amount
) {
}
