package com.imtoocai.diary.service;

import com.imtoocai.diary.model.Result;

public interface ChangePassword {
    Result ChangePassword(String email, Integer oldPassword, Integer newPassword);

    Result ChangePassword(Integer userId, Integer oldPassword, Integer newPassword);
}
