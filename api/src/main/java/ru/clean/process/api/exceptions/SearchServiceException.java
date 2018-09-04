package ru.clean.process.api.exceptions;

import java.text.MessageFormat;

/**
 * Exception for search module
 */
public class SearchServiceException extends Exception {
    public SearchServiceException(String message) {
        super(message);
    }

    public SearchServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SearchServiceException(String message, Object... arguments) {
        super(MessageFormat.format(message, arguments));
    }
}
