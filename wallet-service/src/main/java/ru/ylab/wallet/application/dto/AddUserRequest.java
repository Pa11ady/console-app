package ru.ylab.wallet.application.dto;

import java.util.UUID;

public record AddUserRequest(
        UUID userId,
        String fullName,
        String login,
        String password) {
}
