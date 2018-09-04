package ru.clean.process.api.exceptions;

import java.text.MessageFormat;

/**
 * Exception for User service
 */
public class UnexpectedException extends RuntimeException {
    public UnexpectedException(String message) {
        super(message);
    }

    public UnexpectedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnexpectedException(String message, Object... arguments) {
        super(MessageFormat.format(message, arguments));
    }
}
