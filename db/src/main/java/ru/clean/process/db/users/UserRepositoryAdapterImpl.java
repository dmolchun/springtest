package ru.clean.process.db.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.repo_adapters.UserRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter to work with user storage
 */
@Service
public class UserRepositoryAdapterImpl implements UserRepositoryAdapter {

    private UserRepository userRepository;

    @Autowired
    public UserRepositoryAdapterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return new ArrayList<>(userRepository.findAll());
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity(user);
        return userRepository.save(userEntity);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
