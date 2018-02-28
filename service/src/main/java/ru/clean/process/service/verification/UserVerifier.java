package ru.clean.process.service.verification;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.repo_adapters.UserRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * To verify User DTO
 */
@Service
public class UserVerifier {
    private static final String ID_PROPERTY_NAME = "id";
    private static final String LOGIN_PROPERTY_NAME = "login";
    private static final String NAME_PROPERTY_NAME = "namea";

    private final UserRepositoryAdapter userRepository;

    public UserVerifier(UserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Verify user DTO when create a new one
     *
     * @param user user to create
     * @return list of verification errors
     */
    public List<VerificationResult> verifyUserOnCreate(User user) {
        List<VerificationResult> verificationResult = new ArrayList<>();
        if (!StringUtils.isEmpty(user.getLogin()) && isUserExisted(user.getLogin())) {
            verificationResult.add(new VerificationResult(LOGIN_PROPERTY_NAME,
                    String.format("User with login %s already exists", user.getLogin())));
        }
        if (!StringUtils.isEmpty(user.getId())) {
            verificationResult.add(new VerificationResult(ID_PROPERTY_NAME,
                    String.format("User with id (%d) is already exist", user.getId())));
        }
        verifyCommonUserProps(user, verificationResult);
        return verificationResult;
    }

    /**
     * Verify user DTO when create new one
     *
     * @param user user to create
     * @return list of verification errors
     */
    public List<VerificationResult> verifyUserOnUpdate(User user) {
        List<VerificationResult> verificationResult = new ArrayList<>();
        if (StringUtils.isEmpty(user.getId())) {
            verificationResult.add(new VerificationResult(ID_PROPERTY_NAME, "User has empty id"));
        }
        if (!StringUtils.isEmpty(user.getId()) && !isUserExisted(user.getId())) {
            verificationResult.add(new VerificationResult(LOGIN_PROPERTY_NAME,
                    String.format("User with id %d is not exist", user.getId())));
        }
        verifyCommonUserProps(user, verificationResult);
        return verificationResult;
    }

    /**
     * Common verification for User DTO
     */
    private void verifyCommonUserProps(User user, List<VerificationResult> verificationResult) {
        if (StringUtils.isEmpty(user.getLogin())) {
            verificationResult.add(new VerificationResult(LOGIN_PROPERTY_NAME,"User has empty login"));
        }
        if (StringUtils.isEmpty(user.getName())) {
            verificationResult.add(new VerificationResult(NAME_PROPERTY_NAME,"User has empty name"));
        }
    }

    /**
     * Check if user already exists
     *
     * @param login - user login
     * @return true if user already exists
     */
    private boolean isUserExisted(String login) {
        User existedUser = userRepository.getUserByLogin(login);
        return existedUser != null;
    }

    /**
     * Check if user already exists
     *
     * @param id - user id
     * @return true if user already exists
     */
    private boolean isUserExisted(Long id) {
        User existedUser = userRepository.getUserById(id);
        return existedUser != null;
    }
}
