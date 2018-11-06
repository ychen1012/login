package com.imtoocai.diary.controller;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.service.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {
    @Autowired
    private Register register;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Boolean register(@RequestBody User user) {
        return register.userRegister(user);
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() {
        return "helloworld";
    }
}
