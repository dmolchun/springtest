package ru.clean.process.db.users;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.clean.process.db.users.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
