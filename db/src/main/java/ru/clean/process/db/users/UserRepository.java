package ru.clean.process.db.users;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.db.users.UserEntity;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Returns user entity by user login
     * @param login - user login
     * @return - user entity
     */
    @Query("select u from UserEntity u where u.login = ?1")
    UserEntity findByLogin(String login);

    @Modifying
    @Transactional
    @Query("update UserEntity set password = ?2 where id = ?1")
    void changePassword(Long id, String password);

}
