package ru.clean.process.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.clean.process.api.constants.ConfigConstants;
import ru.clean.process.api.dto.user.UserRoles;
import ru.clean.process.service.user.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan({ConfigConstants.PACKAGE_SERVICES})
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //todo: enable csfr
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/app/**", "/main", "/ui/**").access("hasAnyAuthority('" + UserRoles.ADMIN.name() + "', '" + UserRoles.USER.name() + "')")
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/", false);

    }
}