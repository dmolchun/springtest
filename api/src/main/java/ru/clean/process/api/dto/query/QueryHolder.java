package ru.clean.process.api.dto.query;

import ru.clean.process.api.exceptions.SearchServiceException;

/**
 * Interface for DTO, which holds search query attributes
 */
public interface QueryHolder {
    Condition getCondition() throws SearchServiceException;
}
