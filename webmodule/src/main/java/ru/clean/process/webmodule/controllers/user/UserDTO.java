package ru.clean.process.webmodule.controllers.user;

import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.dto.user.UserImpl;

/**
 * User DTO for web module
 */
public class UserDTO extends UserImpl {
    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.secondName = user.getSecondName();
        this.login = user.getLogin();
        this.userRoles = user.getRoles();
    }

}
