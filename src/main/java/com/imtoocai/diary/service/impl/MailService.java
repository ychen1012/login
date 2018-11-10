package com.imtoocai.diary.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Value("${spring.mail.username}")
    private String mailfrom;

    @Autowired
    private JavaMailSender mailSender;

    @Resource
    TemplateEngine templateEngine;

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(mailfrom);
        mailSender.send(simpleMailMessage);


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
