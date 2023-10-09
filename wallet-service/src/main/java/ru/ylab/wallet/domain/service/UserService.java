package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.model.User;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserService {
    public User createUser(User user) {
        return null;
    }

    public Optional<User> findUserById(UUID userId) {
        return Optional.empty();
    }

    public Optional<User> findUserByLogin(String login) {
        return Optional.empty();
    }

    public User updateUser(User user) {
        return null;
    }
}
