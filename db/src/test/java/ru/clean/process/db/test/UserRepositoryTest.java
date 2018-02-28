package ru.clean.process.db.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.clean.process.api.dto.user.User;
import ru.clean.process.api.dto.user.UserImpl;
import ru.clean.process.db.users.UserEntity;
import ru.clean.process.db.users.UserRepository;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {TestJpaConfig.class},
        loader = AnnotationConfigContextLoader.class)
public class UserRepositoryTest {


    @Resource
    private UserRepository userRepository;

    @Test
    public void testFindUser() {
        UserImpl testUser = new UserImpl();
        testUser.setLogin("user1");
        testUser.setName("user1name");
        testUser.setSecondName("user1secondName");

        userRepository.save(new UserEntity(testUser));

        User foundUser = userRepository.findByLogin(testUser.getLogin());

        Assert.assertEquals(foundUser.getSecondName(), testUser.getSecondName());
    }
}
