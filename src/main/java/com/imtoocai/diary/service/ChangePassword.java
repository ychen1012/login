package com.imtoocai.diary.service;

import com.imtoocai.diary.model.Result;

public interface ChangePassword {
    Result ChangePassword(String email, String oldPassword, String newPassword);
}
