package ru.ylab.wallet.application;

import ru.ylab.wallet.application.dto.AddTransactionRequest;
import ru.ylab.wallet.application.dto.AddUserRequest;
import ru.ylab.wallet.application.dto.AuthenticationRequest;
import ru.ylab.wallet.application.dto.UserInfoResponse;

import java.util.Optional;
import java.util.UUID;

public class WalletFacade {
    public void registerUser(AddUserRequest request) {

    }

    public Optional<UUID> authenticate(AuthenticationRequest request) {
        return Optional.of(UUID.randomUUID());
    }

    public Optional<UserInfoResponse> getUserInfo(UUID id) {
        return Optional.of(new UserInfoResponse("Name", "login", 101));
    }

    public void createDebitTransaction(AddTransactionRequest request) {
        System.out.println("списали деньги");
    }

    public void createCreditTransaction(AddTransactionRequest request) {
        System.out.println("пополнили деньги");
    }
}
