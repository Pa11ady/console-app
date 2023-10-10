package ru.ylab.wallet.infrastructure.storage.stub;

import ru.ylab.wallet.domain.UserRepository;
import ru.ylab.wallet.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public class StubUserRepository implements UserRepository {
    @Override
    public User createUser(User user) {
        return user;
    }

    @Override
    public Optional<User> findUserById(UUID userId) {
        return Optional.of(new User(
                UUID.randomUUID(),
                "User1",
                "userlogin1",
                "pass1",
                1000
        ));
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        if (!"www".equals(login)) {
            return Optional.empty();
        }
        return Optional.of(new User(
                UUID.randomUUID(),
                "qqq",
                "www",
                "eee",
                1000
        ));
    }

    @Override
    public User updateUser(User user) {
        return user;
    }
}
