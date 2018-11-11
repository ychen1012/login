package com.imtoocai.diary.service.impl;


import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.TimeUnit;

@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String mailfrom;

    @Autowired
    private JavaMailSender mailSender;

    @Resource
    TemplateEngine templateEngine;

    @Autowired
    StringRedisTemplate redisTemplate;

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(mailfrom);
        mailSender.send(simpleMailMessage);


    }

    public Result sentMail(String email) {
        String code = CodeUtil.getCode();
        try {

            sendSimpleMail(email, "重置密码", "您好，您进行了重置密码操作，验证码为" + code);
            redisTemplate.opsForValue().set(email, code, 2000, TimeUnit.MINUTES);
            return Result.builder().result(Boolean.TRUE).msg("已发送到您的邮箱").build();
        } catch (Exception e) {
            return Result.builder().result(Boolean.FALSE).msg("发送失败").build();
        }


    }

    public void setTmeplateMail(String to, String subject) throws MessagingException {
        Context context = new Context();
        context.setVariable("code", "*#06#");
        String emailContent = templateEngine.process("emailTemple", context);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(mailfrom);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(emailContent, true);
        mailSender.send(mimeMessage);

    }
}
