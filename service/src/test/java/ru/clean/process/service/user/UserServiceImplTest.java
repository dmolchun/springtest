package ru.clean.process.service.user;

import org.junit.Before;
import org.junit.Test;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.UserService;
import ru.clean.process.api.service.repo_adapters.UserRepositoryAdapter;
import ru.clean.process.service.verification.UserVerifier;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * User service tests
 */
public class UserServiceImplTest {
    UserService userService;

    @Before
    public void initialize() {
        UserRepositoryAdapter userRepositoryAdapter = new UserRepositoryAdapterMock();
        userService = new UserServiceImpl(userRepositoryAdapter, new UserVerifier(userRepositoryAdapter));
    }

    @Test
    public void getAllTest() {
        List<User> users = userService.getAllUser();
        assertEquals(4, users.size());
        assertEquals(1L, users.get(0).getId().longValue());
        assertEquals(2L, users.get(1).getId().longValue());
    }
}
