package ru.clean.process.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.repo_adapters.UserRepositoryAdapter;
import ru.clean.process.api.service.UserService;

import java.util.List;

/**
 * Actor service implementation
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryAdapter userRepository;

    @Autowired
    public UserServiceImpl(UserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }
}
