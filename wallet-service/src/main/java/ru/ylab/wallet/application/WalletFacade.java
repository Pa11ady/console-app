package ru.ylab.wallet.application;

import ru.ylab.wallet.application.dto.*;
import ru.ylab.wallet.application.exception.LoginNotUniqueException;
import ru.ylab.wallet.application.exception.TransactionIdNotUniqueException;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WalletFacade {
    public void registerUser(AddUserRequest request) {
        throw new LoginNotUniqueException();
    }

    public Optional<UUID> authenticate(AuthenticationRequest request) {
        return Optional.of(UUID.randomUUID());
    }

    public Optional<UserInfoResponse> getUserInfo(UUID id) {
        return Optional.of(new UserInfoResponse("Name", "login", 101));
    }

    public void createDebitTransaction(AddTransactionRequest request) {
        throw new TransactionIdNotUniqueException();
    }

    public void createCreditTransaction(AddTransactionRequest request) {
        throw new TransactionIdNotUniqueException();
    }

    public List<TransactionResponse> transactionHistory(UUID userId) {
        OffsetDateTime dateTime = OffsetDateTime.now();
        List<TransactionResponse> transactions = Stream.of(
                new TransactionResponse(UUID.randomUUID(), dateTime.plusMinutes(20), 2000),
                new TransactionResponse(UUID.randomUUID(), dateTime.plusMinutes(10), 1000),
                new TransactionResponse(UUID.randomUUID(), dateTime, -100)

        ).collect(Collectors.toCollection(ArrayList::new));
        return transactions;
    }

    public List<EventResponse> getAllEvents() {
        OffsetDateTime dateTime = OffsetDateTime.now();
        return Stream.of(
                new EventResponse("user1", dateTime.plusMinutes(20), "логин"),
                new EventResponse("user1", dateTime.plusMinutes(10), "пополнение 10"),
                new EventResponse("user1", dateTime.plusMinutes(30), "вход"),
                new EventResponse("tttt", dateTime.plusMinutes(21), "снятие денег 10"),
                new EventResponse("taa", dateTime.plusMinutes(21), "пополнение 123")
        ).collect(Collectors.toCollection(ArrayList::new));
    }
}
