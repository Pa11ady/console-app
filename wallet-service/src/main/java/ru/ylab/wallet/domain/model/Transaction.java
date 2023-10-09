package ru.ylab.wallet.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
        private UUID userId;
        private UUID transactionId;
        private OffsetDateTime transactionDate;
        private long amount;
}
