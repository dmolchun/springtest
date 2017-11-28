package ru.clean.process.api.dto.config;

/**
 * Main config dto
 */
public class MainConfigImpl implements MainConfig {
    private DbConfig dbConfig;
    private boolean needCreateAdminIfNotExists;

    @Override
    public DbConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    @Override
    public boolean needCreateAdminIfNotExists() {
        return needCreateAdminIfNotExists;
    }

    public void setNeedCreateAdminIfNotExists(boolean needCreateAdminIfNotExists) {
        this.needCreateAdminIfNotExists = needCreateAdminIfNotExists;
    }
}
