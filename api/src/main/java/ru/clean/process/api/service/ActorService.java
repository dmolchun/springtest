package ru.clean.process.api.service;

import ru.clean.process.api.dto.actor.Actor;

import java.util.List;

/**
 * Actor service interface
 */
public interface ActorService {
    List<Actor> getAllActors();
}
