package ru.ylab.wallet.infrastructure.storage.memory;

import ru.ylab.wallet.domain.UserRepository;
import ru.ylab.wallet.domain.model.User;

import java.util.*;

public class MemoryStubUserRepository implements UserRepository {
    private final Map<UUID, User> userMap = new HashMap<>();

    @Override
    public User createUser(User user) {
        saveUser(user);
        return user;
    }

    @Override
    public Optional<User> findUserById(UUID userId) {
        return Optional.ofNullable(userMap.get(userId));
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return userMap.values().stream()
                .filter(user -> login.equals(user.getLogin()))
                .findAny();
    }

    @Override
    public User updateUser(User user) {
        saveUser(user);
        return user;
    }

    private void saveUser(User user) {
        User copy = new User(
                user.getId(),
                user.getFullName(),
                user.getLogin(),
                user.getPassword(),
                user.getBalance()
        );
        userMap.put(copy.getId(), copy);
    }
}
