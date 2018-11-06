package com.imtoocai.diary.repo;

import com.imtoocai.diary.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepoTest {
    @Autowired
    private UserRepo userRepo;

    @Test
    public void test() {
        User user = new User();
        user.setUserName("test11");
        user.setEmail("abc@qq.com");
        user.setPassword(1234);

        System.out.println(userRepo.findAll());
    }

}