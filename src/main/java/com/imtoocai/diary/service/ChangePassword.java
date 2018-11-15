package com.imtoocai.diary.service;

import com.imtoocai.diary.model.Result;

public interface ChangePassword {
    Result ChangePassword(String email, Long oldPassword, Long  newPassword);

    Result ChangePassword(Integer userId, Long oldPassword, Long newPassword);
}
