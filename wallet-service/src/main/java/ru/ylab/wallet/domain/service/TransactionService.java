package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.TransactionRepository;
import ru.ylab.wallet.domain.model.Transaction;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.createTransaction(transaction);
    }

    public Optional<Transaction> findTransactionById(UUID transactionId) {
        return transactionRepository.findTransactionById(transactionId);
    }

    public List<Transaction> findAllByUserId(UUID userId) {
        return transactionRepository.findAllByUserId(userId);
    }
}
