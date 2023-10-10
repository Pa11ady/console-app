package ru.ylab.wallet.domain.service;

import lombok.RequiredArgsConstructor;
import ru.ylab.wallet.domain.UserRepository;
import ru.ylab.wallet.domain.exception.IdNotUniqueException;
import ru.ylab.wallet.domain.exception.InvalidIdException;
import ru.ylab.wallet.domain.exception.LoginNotUniqueException;
import ru.ylab.wallet.domain.exception.UserNotFoundException;
import ru.ylab.wallet.domain.model.User;

import java.util.Optional;
import java.util.UUID;

/**
 * Сервис для работы с пользователями.
 * Этот сервис предоставляет функциональность
 * для создания, поиска и обновления информации о пользователях.
 */

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        if (user.getId() == null) {
            throw  new InvalidIdException();
        }
        if (findUserByLogin(user.getLogin()).isPresent()) {
            throw new LoginNotUniqueException();
        }
        if (findUserById(user.getId()).isPresent()) {
            throw new IdNotUniqueException();
        }
        return userRepository.createUser(user);
    }

    public Optional<User> findUserById(UUID userId) {
        return userRepository.findUserById(userId);
    }

    public Optional<User> findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public User updateUser(User user) {
        if (user.getId() == null) {
            throw  new InvalidIdException();
        }
        findUserById(user.getId()).orElseThrow(UserNotFoundException::new);
        return userRepository.updateUser(user);
    }
}
