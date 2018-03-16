package ru.clean.process.api.service.repo_adapters;

import ru.clean.process.api.dto.user.User;

import java.util.List;

/**
 * Adapter interface to work with user storage
 */
public interface UserRepositoryAdapter {
    List<User> getAllUser();
    User saveUser(User user);
    User getUserByLogin(String login);
    User getUserById(Long id);
}
