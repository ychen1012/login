package com.imtoocai.diary.controller;

import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.service.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {
    @Autowired
    private Login login;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public Result validEmail(@RequestParam String email) {
        return login.emailExist(email);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result Login(@RequestParam String email, @RequestParam String password) {
        return login.login(email, password);

    }
}
