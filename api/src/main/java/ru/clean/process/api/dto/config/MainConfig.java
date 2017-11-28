package ru.clean.process.api.dto.config;

/**
 * Interface for main config dto
 */
public interface MainConfig {
    DbConfig getDbConfig();
    boolean needCreateAdminIfNotExists();
}
