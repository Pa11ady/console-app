package ru.ylab.wallet.application.dto;

public record AuthenticationRequest(
        String login,
        String password) {
}
