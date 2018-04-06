package ru.clean.process.api.exceptions;

import java.text.MessageFormat;

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

    public UserServiceException(String message, Object... arguments) {
        super(MessageFormat.format(message, arguments));
    }
}
