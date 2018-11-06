package com.imtoocai.diary.service.impl;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.repo.UserRepo;
import com.imtoocai.diary.service.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterImpl implements Register {
    @Autowired
    private UserRepo userRepo;

    @Override
    public Boolean userRegister(User user) {
        User user1 = userRepo.save(user);
        if (user1 == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
