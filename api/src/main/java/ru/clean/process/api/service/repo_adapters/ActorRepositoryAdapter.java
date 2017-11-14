package ru.clean.process.api.service.repo_adapters;

import ru.clean.process.api.dto.actor.Actor;
import ru.clean.process.api.dto.user.User;

import java.util.List;

/**
 * Adapter interface to work with actor storage
 */
public interface ActorRepositoryAdapter {
    List<Actor> getAllActors();
}
