package com.imtoocai.diary.service;

import com.imtoocai.diary.model.Result;

public interface ResetPassword {
    Result resetPassword(String email, String code, Integer newPassword);

}
