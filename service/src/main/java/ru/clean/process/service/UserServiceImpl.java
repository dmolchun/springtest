package ru.clean.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.ActorService;
import ru.clean.process.api.service.UserService;
import ru.clean.process.db.users.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Actor service implementation
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return new ArrayList<>(userRepository.findAll());
    }
}
