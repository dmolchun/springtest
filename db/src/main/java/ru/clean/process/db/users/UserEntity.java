package ru.clean.process.db.users;

import ru.clean.process.api.dto.user.User;

import javax.persistence.*;


/**
 * User entity for JPA
 */

@Entity
@Table(name = "users")
public class UserEntity implements User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    public Long getId() {
        return id;
    }
}
