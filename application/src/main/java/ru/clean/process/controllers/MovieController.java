package ru.clean.process.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clean.process.api.dto.actor.Actor;
import ru.clean.process.api.service.ActorService;
import ru.clean.process.db.actors.ActorEntity;
import ru.clean.process.db.actors.ActorRepository;

import java.util.List;


@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    private final ActorService actorService;

    @Autowired
    public MovieController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(value = "/actors")
    public List<Actor> getAllActors() {
        return actorService.getAllActors();
    }
}
