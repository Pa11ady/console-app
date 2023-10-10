package ru.ylab.wallet.application;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.application.dto.*;
import ru.ylab.wallet.application.exception.NotEnoughMoneyException;
import ru.ylab.wallet.common.RubleConverter;
import ru.ylab.wallet.domain.exception.UserNotFoundException;
import ru.ylab.wallet.domain.model.Event;
import ru.ylab.wallet.domain.model.EventType;
import ru.ylab.wallet.domain.model.Transaction;
import ru.ylab.wallet.domain.model.User;
import ru.ylab.wallet.domain.service.EventService;
import ru.ylab.wallet.domain.service.TransactionService;
import ru.ylab.wallet.domain.service.UserService;

import java.time.OffsetDateTime;
import java.util.*;

/**
 * Этот в какой-то степени фасад для взаимодействия с внешними слоями луковичной архитектуры.
 * По сути это бизнес логика более высокого уровня. Возможно он нарушает принципы SOLID, так как
 * много берёт на себя, но он нужен чтобы инкапсулировать и собрать внутреннею бизнес логику.
 * Он обеспечивает управление пользователями, транзакциями и событиями в приложении.
 */

@RequiredArgsConstructor
public class WalletFacade {
    private final UserService userService;
    private final TransactionService transactionService;
    private final EventService eventService;

    public void registerUser(AddUserRequest request) {
        userService.createUser(new User(
                request.userId(),
                request.fullName(),
                request.login(),
                request.password(),
                0L
        ));
    }

    public Optional<UUID> authenticate(AuthenticationRequest request) {
        Optional<User> userOptional = userService.findUserByLogin(request.login());
        if (userOptional.isEmpty()) {
            return Optional.empty();
        }
        User user = userOptional.get();
        if (Objects.equals(user.getPassword(), request.password())) {
            recordEvent(user, EventType.LOGIN, "");
            return Optional.of(user.getId());
        }
        return Optional.empty();
    }

    public Optional<UserInfoResponse> getUserInfo(UUID userId) {
        Optional<User> userOptional = userService.findUserById(userId);
        if (userOptional.isEmpty()) {
            return Optional.empty();
        }
        User user = userOptional.get();
        return Optional.of(new UserInfoResponse(
                user.getFullName(),
                user.getLogin(),
                user.getBalance()
        ));
    }

    public void createDebitTransaction(AddTransactionRequest request) {
        User user = userService.findUserById(request.userId()).orElseThrow(UserNotFoundException::new);
        long amount = Math.abs(request.amount());
        if (user.getBalance() - amount < 0) {
            throw new NotEnoughMoneyException();
        }

        transactionService.createTransaction(new Transaction(
                request.userId(),
                request.transactionId(),
                OffsetDateTime.now(),
                -request.amount()
        ));
        user.setBalance(user.getBalance() - amount);
        userService.updateUser(user);
        recordEvent(user, EventType.DEBIT, RubleConverter.kopecksToRubles(-request.amount()));
    }

    public void createCreditTransaction(AddTransactionRequest request) {
        User user = userService.findUserById(request.userId()).orElseThrow(UserNotFoundException::new);
        long amount = Math.abs(request.amount());
        transactionService.createTransaction(new Transaction(
                request.userId(),
                request.transactionId(),
                OffsetDateTime.now(),
                request.amount()
        ));
        user.setBalance(user.getBalance() + amount);
        userService.updateUser(user);
        recordEvent(user, EventType.CREDIT, RubleConverter.kopecksToRubles(request.amount()));
    }

    public List<TransactionResponse> transactionHistory(UUID userId) {
        List<TransactionResponse> result = new ArrayList<>();
        List<Transaction> transactions = transactionService.findAllByUserId(userId);
        for (Transaction transaction : transactions) {
            result.add(new TransactionResponse(
                    transaction.getTransactionId(),
                    transaction.getTransactionDate(),
                    transaction.getAmount()
            ));
        }
        return result;
    }

    public List<EventResponse> getAllEvents() {
        List<EventResponse> result = new ArrayList<>();
        List<Event> events = eventService.findAll();
        for (Event event : events) {
            result.add(new EventResponse(
                    event.getUserLogin(),
                    event.getEventDate(),
                    event.getDescription()
            ));
        }
        return result;
    }

    public void logout(UUID token) {
        System.out.println("Выход из профиля");
        userService.findUserById(token).ifPresent(user -> recordEvent(user, EventType.LOGOUT, ""));
    }

    private void recordEvent(User user, EventType eventType, String description) {
        String text = eventType.getDescription();
        if (description != null && !description.isBlank()) {
            text += " " + description;
        }
        eventService.createEvent(new Event(
                UUID.randomUUID(),
                eventType,
                user.getId(),
                user.getLogin(),
                OffsetDateTime.now(),
                text));
    }
}
