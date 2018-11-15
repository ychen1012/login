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
    public Result ChangePassword(String email, Long oldPassword, Long newPassword) {
        List<User> byEmail = userRepo.findByEmail(email);
        if (byEmail.size() <= 0) {
            return Result.builder().result(Boolean.FALSE).msg("用户不存在").build();
        }
        if (byEmail.get(0).getPassword().equals(oldPassword)) {
            User user = byEmail.get(0);
            user.setPassword(newPassword);
            userRepo.saveAndFlush(user);
            return Result.builder().result(Boolean.TRUE).msg("密码重置成功").build();
        }
        if (!byEmail.get(0).getPassword().equals(oldPassword)) {
            return Result.builder().result(Boolean.FALSE).msg("密码不正确").build();
        }


        return Result.builder().result(Boolean.FALSE).msg("未知错误").build();
    }


    public Result ChangePassword(Integer userId, Long oldPassword, Long newPassword) {
        User allByUserId = userRepo.findAllByUserId(userId);
        if (allByUserId == null) {
            return Result.builder().result(Boolean.FALSE).msg("用户不存在").userId(userId).build();
        }
        if (allByUserId.getPassword().equals(oldPassword)) {
            allByUserId.setPassword(newPassword);
            userRepo.saveAndFlush(allByUserId);
            return Result.builder().result(Boolean.TRUE).msg("密码重置成功").userId(userId).build();
        }

        return Result.builder().result(Boolean.FALSE).msg("未知错误").userId(userId).build();
    }
}
