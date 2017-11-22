package ru.clean.process.api.exceptions;

/**
 * Exception for User service
 */
public class UserServiceException extends Exception {
    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
