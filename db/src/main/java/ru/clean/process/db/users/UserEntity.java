package ru.clean.process.db.users;

import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.dto.user.UserRoles;

import javax.persistence.*;
import java.util.List;


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

    @Column(name = "user_name")
    String name;

    @Column(name = "second_name")
    String secondName;

    @Column(name = "user_login")
    String login;

    @Column(name = "user_password")
    String password;

//    @Column(name = "user_roles")
//    List<UserRoles> userRoles;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

//    @Override
//    public List<UserRoles> getRoles() {
//        return userRoles;
//    }
}
