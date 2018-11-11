package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.repo.UserRepo;
import com.imtoocai.diary.service.ChangePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangePasswordImpl implements ChangePassword {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Result ChangePassword(String email, Integer oldPassword, Integer newPasswor) {
        List<User> byEmail = userRepo.findByEmail(email);
        if (byEmail.size() <= 0) {
            return Result.builder().result(Boolean.FALSE).msg("用户不存在").build();
        }
        if (byEmail.get(0).getPassword().equals(oldPassword)) {
            User user = byEmail.get(0);
            user.setPassword(newPasswor);
            userRepo.saveAndFlush(user);
            return Result.builder().result(Boolean.TRUE).msg("密码重置成功").build();
        }


        return null;
    }
}