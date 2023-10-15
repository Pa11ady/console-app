package ru.ylab.wallet.infrastructure.storage.memory;

import ru.ylab.wallet.domain.TransactionRepository;
import ru.ylab.wallet.domain.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryTransactionRepository implements TransactionRepository {
    private final Map<UUID, Transaction> transactionMap = new HashMap<>();

    @Override
    public Transaction createTransaction(Transaction transaction) {
        Transaction copy = new Transaction(
                transaction.getUserId(),
                transaction.getTransactionId(),
                transaction.getTransactionDate(),
                transaction.getAmount()
        );
        transactionMap.put(copy.getTransactionId(), copy);
        return transaction;
    }

    @Override
    public Optional<Transaction> findTransactionById(UUID transactionId) {
        return Optional.ofNullable(transactionMap.get(transactionId));
    }

    @Override
    public List<Transaction> findAllByUserId(UUID userId) {
        return transactionMap.values().stream()
                .filter(transaction -> userId.equals(transaction.getUserId()))
                .collect(Collectors.toList());
    }
}
