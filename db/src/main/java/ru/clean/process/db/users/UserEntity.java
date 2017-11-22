package ru.clean.process.db.users;

import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.dto.user.UserRoles;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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
    private String name;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_roles")
    String[] userRoles;

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

    @Override
    public List<UserRoles> getRoles() {
        if (userRoles == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(userRoles).stream().map(UserRoles::valueOf).collect(Collectors.toList());
    }

    public UserEntity() {
    }

    public UserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.secondName = user.getSecondName();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRoles=" + Arrays.toString(userRoles) +
                '}';
    }
}
