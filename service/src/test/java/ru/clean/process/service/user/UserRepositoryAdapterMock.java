package ru.clean.process.service.user;

import org.mockito.Mockito;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.repo_adapters.UserRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User repository mock class
 */
public class UserRepositoryAdapterMock implements UserRepositoryAdapter {
    @Override
    public List<User> getAllUser() {
        User user = Mockito.mock(User.class);
        Mockito.when(user.getId()).thenReturn(1L).thenReturn(2L).thenReturn(3L).thenReturn(4L);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            users.add(user);
        }
        return users;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User getUserByLogin(String login) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public void changePassword(Long id, String password) {

    }
}
