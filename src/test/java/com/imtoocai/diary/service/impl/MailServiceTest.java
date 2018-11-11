package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.util.CodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendMailTest(){
        mailService.sendSimpleMail("13681132624@139.com","重置密码","您好，您进行了重置密码操作，验证码为"+CodeUtil.getCode());
    }


}