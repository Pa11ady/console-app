package ru.ylab.wallet.application.dto;

import java.util.UUID;

public record AddUserRequest(
        UUID id,
        String fullName,
        String login,
        String password) {
}
