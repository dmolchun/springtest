package ru.clean.process.api.dto.config;

/**
 * Main config dto
 */
public class MainConfigImpl implements MainConfig {
    private DbConfig dbConfig;

    public DbConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
}
