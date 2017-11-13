package ru.clean.process.api.service;

import ru.clean.process.api.dto.user.User;

import java.util.List;

/**
 * User service interface
 */
public interface UserService {
    List<User> getAllUser();
}
