package com.imtoocai.diary.controller;

import com.imtoocai.diary.entity.User;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.service.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {
    @Autowired
    private Register register;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder msg = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                msg.append(error.getDefaultMessage());
            }
            return Result.builder().result(Boolean.FALSE).msg(msg.toString()).build();
        }
        User user1=new User();
        return register.userRegister(user);
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello world，i am  zbnnnnnn";
    }
}
