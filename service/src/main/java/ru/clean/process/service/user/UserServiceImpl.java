package ru.clean.process.service.user;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.dto.user.UserImpl;
import ru.clean.process.api.dto.user.UserRoles;
import ru.clean.process.api.exceptions.UserServiceException;
import ru.clean.process.api.service.UserService;
import ru.clean.process.api.service.repo_adapters.UserRepositoryAdapter;
import ru.clean.process.service.verification.UserVerifier;
import ru.clean.process.service.verification.VerificationResult;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User service implementation
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryAdapter userRepository;
    private final UserVerifier userVerifier;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepositoryAdapter userRepository, UserVerifier userVerifier, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userVerifier = userVerifier;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getCurrentUser() throws UserServiceException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails currentUserDetails = (UserDetails) authentication.getPrincipal();
            return getUserByLogin(currentUserDetails.getUsername());
        }
        throw new UserServiceException("User is not authenticated");
    }

    @Override
    public User saveUser(User user) throws UserServiceException {
        checkAdmin("save user");
        if (user.getId() == null) {
            return createUser(user);
        }
        return updateUser(user);
    }

    @Override
    public void deleteUser(Long id) throws UserServiceException {
        checkAdmin("delete user");
        getUserById(id);
        userRepository.deleteUser(id);
    }

    /**
     * Returns user info by login
     *
     * @throws UserServiceException if user was not found
     */
    @Override
    public User getUserByLogin(String login) throws UserServiceException {
        User result = userRepository.getUserByLogin(login);
        if (result == null) {
            throw new UserServiceException(String.format("User with name %s was not found", login));
        }
        return result;
    }

    /**
     * Returns user info by id
     *
     * @throws UserServiceException if user was not found
     */
    @Override
    public User getUserById(Long id) throws UserServiceException {
        User result = userRepository.getUserById(id);
        if (result == null) {
            throw new UserServiceException(String.format("User with id %d was not found", id));
        }
        return result;
    }

    /**
     * Changes user's password
     *
     * @throws UserServiceException if user was not found
     */
    @Override
    public void changePassword(Long id, String password) throws UserServiceException {
        if (id == null) {
            throw new UserServiceException("User id is not set");
        }
        checkAdmin("change password");

        userRepository.changePassword(id, passwordEncoder.encode(password));
    }

    /**
     * Update existed user
     * <p>
     * UserServiceException if user DTO hasn't pass verification
     */
    private User updateUser(User user) throws UserServiceException {
        checkAdmin("update user");
        List<VerificationResult> verificationResult = userVerifier.verifyUserOnUpdate(user);
        if (verificationResult.isEmpty()) {
            return saveToRepo(user);
        } else {
            throw new UserServiceException(String.format("Unable to update user because: \n%s",
                    verificationResult.stream().map(VerificationResult::getErrorMessage).collect(Collectors.joining("\n"))));
        }
    }

    /**
     * Create new user
     *
     * @throws UserServiceException if user DTO hasn't pass verification
     */
    private User createUser(User user) throws UserServiceException {
        List<VerificationResult> verificationResult = userVerifier.verifyUserOnCreate(user);
        if (verificationResult.isEmpty()) {
            return saveToRepo(user);
        } else {
            throw new UserServiceException(String.format("Unable to create user because: \n%s",
                    verificationResult.stream().map(VerificationResult::getErrorMessage).collect(Collectors.joining("\n"))));
        }
    }

    /**
     * Save user to repo
     */
    private User saveToRepo(User user) throws UserServiceException {
        if (user == null) {
            throw new UserServiceException("User to save in repo empty");
        }
        UserImpl newUser = new UserImpl(user);
        if (user.getId() == null) {
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.saveUser(newUser);
    }

    private void checkAdmin(String action) throws UserServiceException {
        User currentUser = getCurrentUser();
        if (!currentUser.getRoles().contains(UserRoles.ADMIN)) {
            throw new UserServiceException("Current user id = {} is not authorised to {}", currentUser.getId(), action);
        }
    }
}
