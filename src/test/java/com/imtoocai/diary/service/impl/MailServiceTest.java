package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.util.CodeUtil;
import com.imtoocai.diary.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;

//    @Autowired
//    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void sendMailTest() {
        String code = CodeUtil.getCode();
        //key value 失效时间 单位
        redisTemplate.opsForValue().set("13681132624@163.com", code, 300, TimeUnit.SECONDS);
        mailService.sendSimpleMail("13681132624@163.com", "重置密码", "您好，您进行了重置密码操作，验证码为" + code);
        System.out.println(redisTemplate.opsForValue().get("13681132624@163.com"));
    }


}