package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.repo.UserRepo;
import com.imtoocai.diary.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginImpl implements Login {
    @Autowired
    private UserRepo userRepo;


    @Override
    public Result emailExist(String email) {
        List<User> byEmail = userRepo.findByEmail(email);
        if (byEmail.size() <= 0) {
            return Result.builder().result(Boolean.FALSE).msg("邮箱不存在").build();
        }
        return Result.builder().result(Boolean.TRUE).msg("succ").build();

    }

    @Override
    public Result login(String email, String password) {
        List<User> users = userRepo.findByEmail(email);
        if (users.size() <= 0) {
            return Result.builder().result(Boolean.FALSE).msg("邮箱不存在").build();
        }
        for (User user : users) {
            if (user.getPassword().equals(password)) {
                return Result.builder().result(Boolean.TRUE).msg("登录成功").userId(user.getUserId()).build();
            }
        }
        return Result.builder().result(Boolean.FALSE).msg("密码不匹配").build();
    }
}
