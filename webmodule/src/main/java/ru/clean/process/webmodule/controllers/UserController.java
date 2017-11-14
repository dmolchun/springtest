package ru.clean.process.webmodule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.UserService;

import java.util.List;

/**
 * User operations CRUD controller
 */

@RestController
@RequestMapping(value = "/admin")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }
}
