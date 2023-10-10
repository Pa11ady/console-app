package ru.ylab.wallet.domain;

import ru.ylab.wallet.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User createUser(User user);

    Optional<User> findUserById(UUID userId);

    Optional<User> findUserByLogin(String login);

    User updateUser(User user);
}
