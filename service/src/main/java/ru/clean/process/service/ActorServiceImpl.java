package ru.clean.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.actor.Actor;
import ru.clean.process.api.service.ActorService;
import ru.clean.process.db.actors.ActorEntity;
import ru.clean.process.db.actors.ActorRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Actor service implementation
 */
@Service
public class ActorServiceImpl implements ActorService {


    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> getAllActors() {
        return new ArrayList<>(actorRepository.findAll());
    }
}
