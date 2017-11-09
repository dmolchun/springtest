package ru.clean.process.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
