package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.model.Result;

public interface ChangePassword {
    Result ChangePassword(String mailName, String oldPassword, String newPasswor);
}
