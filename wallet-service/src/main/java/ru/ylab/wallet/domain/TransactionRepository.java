package ru.ylab.wallet.domain;

import ru.ylab.wallet.domain.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository {
    Transaction createTransaction(Transaction transaction);

    Optional<Transaction> findTransactionById(UUID transactionId);

    List<Transaction> findAllByUserId(UUID userId);
}
