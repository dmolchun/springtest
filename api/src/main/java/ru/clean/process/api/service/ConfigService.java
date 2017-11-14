package ru.clean.process.api.service;

import ru.clean.process.api.dto.config.MainConfig;

/**
 * Configuration service interface
 */
public interface ConfigService {
    MainConfig getMainConfig();
}
