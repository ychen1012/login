package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.repo.UserRepo;
import com.imtoocai.diary.service.ResetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResetPasswordImpl implements ResetPassword {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public Result resetPassword(String email, String code, Integer newPassword) {
        List<User> userList = userRepo.findByEmail(email);
        if (userList.size() <= 0) {
            return Result.builder().result(Boolean.FALSE).msg("用户不存在").build();
        }
        User user = userList.get(0);
        String currentCode = redisTemplate.opsForValue().get(email);
        if (currentCode == null) {
            return Result.builder().result(Boolean.FALSE).msg("验证码已失效").build();
        }
        if (currentCode.equals(code)) {
            user.setPassword(newPassword);
            userRepo.saveAndFlush(user);
            //redisTemplate.delete(email);
            return Result.builder().result(Boolean.TRUE).msg("重置密码成功").build();
        }
        if (!currentCode.equals(code)) {
            return Result.builder().result(Boolean.FALSE).msg("验证码不正确").build();
        }
        return Result.builder().result(Boolean.FALSE).msg("未知错误").build();
    }
}
