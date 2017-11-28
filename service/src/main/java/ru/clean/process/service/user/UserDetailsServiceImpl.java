package ru.clean.process.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.service.repo_adapters.UserRepositoryAdapter;

/**
 * User details service for spring security authorization
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepositoryAdapter userRepository;

    public UserDetailsServiceImpl(UserRepositoryAdapter userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returns user info for Spring Security authorization
     *
     * @param login - user login
     * @throws UsernameNotFoundException if user was not found
     */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.getUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with login [%s] not found", login));
        }
        return new UserDetailsImpl(user);
    }
}
