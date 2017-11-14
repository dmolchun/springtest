package ru.clean.process.db.actors;


import ru.clean.process.api.dto.actor.Actor;

import javax.persistence.*;

@Entity
@Table(name = "actor")
public class ActorEntity implements Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "actor_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
