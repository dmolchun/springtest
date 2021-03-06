package ru.clean.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.actor.Actor;
import ru.clean.process.api.service.repo_adapters.ActorRepositoryAdapter;
import ru.clean.process.api.service.ActorService;

import java.util.List;

/**
 * Actor service implementation
 */
@Service
public class ActorServiceImpl implements ActorService {


    private final ActorRepositoryAdapter actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepositoryAdapter actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.getAllActors();
    }
}
