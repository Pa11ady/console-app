package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.model.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TransactionService {
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }

    public Optional<Transaction> findTransactionById(UUID TransactionId) {
        return Optional.empty();
    }

    public List<Transaction> findAllByUserId(UUID userId) {
        return Collections.emptyList();
    }
}
