package ru.ylab.wallet.application.dto;

public record UserInfoResponse(
        String fullName,
        String login,
        long balance
) {
}
