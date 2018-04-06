package ru.clean.process.api.service;

import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.exceptions.UserServiceException;

import java.util.List;

/**
 * User service interface
 */
public interface UserService {
    /**
     * Get All users from db
     */
    List<User> getAllUser();

    /**
     * Get current user info from db
     */
    User getCurrentUser() throws UserServiceException;

    /**
     * Save or update user to db
     */
    User saveUser(User user) throws UserServiceException;


    /**
     * Delete user
     */
    void deleteUser(Long id) throws UserServiceException;

    /**
     * Get user from db by user name
     */
    User getUserByLogin(String login) throws UserServiceException;

    /**
     * Get user from db by user id
     */
    User getUserById(Long id) throws UserServiceException;

    /**
     * Changes user's password
     */
    void changePassword(Long id, String password) throws UserServiceException;
}
