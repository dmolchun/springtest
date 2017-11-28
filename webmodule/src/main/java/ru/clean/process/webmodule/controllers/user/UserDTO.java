package ru.clean.process.webmodule.controllers.user;

import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.dto.user.UserImpl;
import ru.clean.process.api.dto.user.UserRoles;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User DTO for web module
 */
public class UserDTO extends UserImpl {

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.secondName = user.getSecondName();
        this.login = user.getLogin();
        this.userRoles = user.getRoles();
    }

}
