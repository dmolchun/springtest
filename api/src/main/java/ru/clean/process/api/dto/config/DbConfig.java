package ru.clean.process.api.dto.config;

/**
 * Interface for db config dto
 */
public interface DbConfig {
    String getDriverClassName();
    String getUrl();
    String getUserName();
    String getPassword();
}
