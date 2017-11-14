package ru.clean.process.db.actors;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.clean.process.db.actors.ActorEntity;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
}
