package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.repo.UserRepo;
import com.imtoocai.diary.service.ChangePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordImpl implements ChangePassword {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Result ChangePassword(String userId, String oldPassword, String newPassword) {
        User allByUserId = userRepo.findAllByUserId(Integer.valueOf(userId));
        if (allByUserId == null) {
            return Result.builder().result(Boolean.FALSE).msg("用户不存在").build();
        }
        if (allByUserId.getPassword().equals(oldPassword)) {

            allByUserId.setPassword(newPassword);
            userRepo.saveAndFlush(allByUserId);
            return Result.builder().result(Boolean.TRUE).msg("密码重置成功").build();
        }
        if (allByUserId.getPassword().equals(oldPassword)) {
            return Result.builder().result(Boolean.FALSE).msg("密码不正确").build();
        }


        return Result.builder().result(Boolean.FALSE).msg("未知错误").build();
    }


}
