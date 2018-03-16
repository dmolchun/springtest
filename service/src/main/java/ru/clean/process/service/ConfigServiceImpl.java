package ru.clean.process.service;

import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.config.DbConfigImpl;
import ru.clean.process.api.dto.config.MainConfig;
import ru.clean.process.api.dto.config.MainConfigImpl;
import ru.clean.process.api.service.ConfigService;

/**
 * Configuration service implementation
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    public MainConfig getMainConfig() {
        DbConfigImpl dbConfig = new DbConfigImpl();
        dbConfig.setDriverClassName("org.postgresql.Driver");
        dbConfig.setUrl("jdbc:postgresql://localhost:5432/dvdrental");
        dbConfig.setUserName("postgres");
        dbConfig.setPassword("root");

        MainConfigImpl mainConfig = new MainConfigImpl();
        mainConfig.setDbConfig(dbConfig);
        mainConfig.setNeedCreateAdminIfNotExists(true);
        return mainConfig;
    }
}
