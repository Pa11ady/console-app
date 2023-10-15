package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.TransactionRepository;
import ru.ylab.wallet.domain.exception.InvalidIdException;
import ru.ylab.wallet.domain.exception.TransactionIdNotUniqueException;
import ru.ylab.wallet.domain.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Сервис для работы с транзакциями (пополнение или списание денег).
 * Этот сервис предоставляет функциональность для создания и поиска транзакций по уникальному идентификатору,
 * а также получения списка всех транзакций для конкретного пользователя.
 */

@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        if (transaction.getTransactionId() == null) {
            throw  new InvalidIdException();
        }
        if (findTransactionById(transaction.getTransactionId()).isPresent()) {
            throw new TransactionIdNotUniqueException();
        }
        return transactionRepository.createTransaction(transaction);
    }

    public Optional<Transaction> findTransactionById(UUID transactionId) {
        return transactionRepository.findTransactionById(transactionId);
    }

    public List<Transaction> findAllByUserId(UUID userId) {
        return transactionRepository.findAllByUserId(userId);
    }
}
