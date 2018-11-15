package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.repo.UserRepo;
import com.imtoocai.diary.service.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterImpl implements Register {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Result userRegister(User user) {
        List<User> result = userRepo.findByUserName(user.getUserName());
        if (result.size() >= 1) {
            return Result.builder().result(Boolean.FALSE).msg("用户名已存在").build();
        }
        if (userRepo.findByEmail(user.getEmail()).size() > 0) {
            return Result.builder().result(Boolean.FALSE).msg("邮箱已存在").build();
        }
        if (result.size() == 0) {
            userRepo.save(user);
            List<User> user1 = userRepo.findByEmail(user.getEmail());
            Integer userId = user1.get(0).getUserId();
            return Result.builder().result(Boolean.TRUE).msg("注册成功").userId(userId).build();
        }


        return null;

    }


}
