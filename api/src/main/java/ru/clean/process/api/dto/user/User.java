package ru.clean.process.api.dto.user;

import java.util.List;

/**
 * Interface to get info about user
 */
public interface User {
    /**
     * Get Id
     */
    Long getId();

    /**
     * Get User name
     */
    String getName();

    /**
     * Get User second name
     */
    String getSecondName();

    /**
     * Get User login
     */
    String getLogin();

    /**
     * Get User password
     */
    String getPassword();

    /**
     * Get User roles
     */
    List<UserRoles> getRoles();
}
