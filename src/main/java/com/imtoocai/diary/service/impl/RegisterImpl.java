package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.repo.UserRepo;
import com.imtoocai.diary.service.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterImpl implements Register {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Result userRegister(User user) {
        User result = userRepo.findByUserName(user.getUserName());
        if (result == null) {
            userRepo.save(user);
            return Result.builder().result(Boolean.TRUE).msg("注册成功").build();
        } else {
            if (result.getEmail().equals(user.getEmail())) {
                return Result.builder().result(Boolean.FALSE).msg("邮箱已存在").build();
            }
            return Result.builder().result(Boolean.FALSE).msg("用户名已存在").build();
        }

    }
}
