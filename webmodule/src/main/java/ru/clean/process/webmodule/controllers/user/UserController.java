package ru.clean.process.webmodule.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.exceptions.UserServiceException;
import ru.clean.process.api.service.UserService;

import javax.xml.ws.Response;
import java.io.Serializable;
import java.util.List;

/**
 * User operations CRUD controller
 */

@RestController
@RequestMapping(value = "/user")
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

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Serializable> saveUser(@RequestBody UserDTO user) {
        try {
            UserDTO savedUser = new UserDTO(userService.saveUser(user));
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
