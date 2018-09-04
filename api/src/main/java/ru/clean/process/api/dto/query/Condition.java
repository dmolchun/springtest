package ru.clean.process.api.dto.query;

/**
 * Base interface for search query condition
 */
public interface Condition {
    ConditionType getType();
}
