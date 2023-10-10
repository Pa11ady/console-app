package ru.ylab.wallet.domain;

import ru.ylab.wallet.domain.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Интерфейс для репозитория транзакций.
 * Этот интерфейс определяет методы для создания транзакций, поиска транзакций по id
 * и получения списка всех транзакций для конкретного пользователя.
 */

public interface TransactionRepository {
    /**
     * Сохраняет транзакцию в репозитории транзакций.
     *
     * @param transaction Объект транзакции для создания включая уникальный идентификатор,
     * передаётся снаружи
     * @return Созданная транзакция

     */
    Transaction createTransaction(Transaction transaction);

    /**
     * Поиск транзакции по уникальному идентификатору.
     *
     * @param transactionId Уникальный идентификатор транзакции.
     * @return Объект транзакции, если он найден, или пустое значение Optional, если транзакция не существует.
     */
    Optional<Transaction> findTransactionById(UUID transactionId);

    /**
     * Получение списка всех транзакций для конкретного пользователя по его уникальному идентификатору.
     *
     * @param userId Уникальный идентификатор пользователя.
     * @return Список всех транзакций, для данного пользователю.
     */
    List<Transaction> findAllByUserId(UUID userId);
}
