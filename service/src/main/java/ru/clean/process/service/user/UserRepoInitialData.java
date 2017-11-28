package ru.clean.process.service.user;

import org.springframework.stereotype.Component;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.dto.user.UserImpl;
import ru.clean.process.api.dto.user.UserRoles;
import ru.clean.process.api.exceptions.UserServiceException;
import ru.clean.process.api.service.ConfigService;
import ru.clean.process.api.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * To create initial admin for application on startup
 */
@Component
public class UserRepoInitialData {

    private final UserService userService;
    private final ConfigService configService;

    public UserRepoInitialData(UserService userService, ConfigService configService) throws UserServiceException {
        this.userService = userService;
        this.configService = configService;
        if (configService.getMainConfig().needCreateAdminIfNotExists()) {
            createAdminIfNotExist();
        }
    }

    /**
     * Creates admin entry, if no admin entries in db yet
     *
     * @throws UserServiceException
     */
    private void createAdminIfNotExist() throws UserServiceException {
        List<User> users = userService.getAllUser();
        boolean isAdminExists = users.stream().flatMap(user -> user.getRoles().stream()).anyMatch(UserRoles.ADMIN::equals);
        if (!isAdminExists) {
            userService.saveUser(createAdminDTO());
        }
    }

    /**
     * Creates admin DTO with log/pass = admin/admin
     */
    private User createAdminDTO() {
        UserImpl admin = new UserImpl();
        admin.setLogin(UserRoles.ADMIN.name().toLowerCase());
        admin.setPassword(UserRoles.ADMIN.name().toLowerCase());
        admin.setName(UserRoles.ADMIN.name().toLowerCase());
        admin.setRoles(Arrays.asList(UserRoles.ADMIN));
        return admin;
    }
}
