package ru.ylab.wallet.infrastructure.storage.stub;

import ru.ylab.wallet.domain.TransactionRepository;
import ru.ylab.wallet.domain.model.Transaction;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class StubTransactionRepository implements TransactionRepository {
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transaction;
    }

    @Override
    public Optional<Transaction> findTransactionById(UUID transactionId) {
//        return Optional.of(new Transaction(
//                UUID.randomUUID(),
//                UUID.randomUUID(),
//                OffsetDateTime.now(),
//                500
//        ));
        return Optional.empty();
    }

    @Override
    public List<Transaction> findAllByUserId(UUID userId) {
        Transaction[] transactions = {
                new Transaction(
                        userId,
                        UUID.randomUUID(),
                        OffsetDateTime.now(),
                        1000
                ),
                new Transaction(
                        userId,
                        UUID.randomUUID(),
                        OffsetDateTime.now(),
                        500
                )
        };
        return Arrays.asList(transactions);
    }
}
