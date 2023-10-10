package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.UserRepository;
import ru.ylab.wallet.domain.model.User;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public Optional<User> findUserById(UUID userId) {
        return userRepository.findUserById(userId);
    }

    public Optional<User> findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
