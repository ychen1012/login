package com.imtoocai.diary.service;

import com.imtoocai.diary.model.Result;

public interface Login {
    Result emailExist(String email);

    Result login(String email, String password);
}