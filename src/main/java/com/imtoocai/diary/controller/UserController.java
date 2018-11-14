package com.imtoocai.diary.controller;

import com.imtoocai.diary.model.ResetInfo;
import com.imtoocai.diary.model.Result;
import com.imtoocai.diary.service.ChangePassword;
import com.imtoocai.diary.service.ResetPassword;
import com.imtoocai.diary.service.impl.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    private ChangePassword changePassword;
    @Autowired
    private ResetPassword resetPassword;
    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/password/change", method = RequestMethod.POST)
    public Result changePassword(@RequestParam String email, @RequestParam Integer oldPassword, @RequestParam Integer newPassword) {
        return changePassword.ChangePassword(email, oldPassword, newPassword);
    }

    @RequestMapping(value = "/password/reset", method = RequestMethod.GET)
    public Result resetPassword(@RequestParam String email, @RequestParam String code, @RequestParam Integer newPassword) {
        return resetPassword.resetPassword(email, code, newPassword);
    }

    @RequestMapping(value = "/password/reset", method = RequestMethod.POST)
    public Result resetPassword(@RequestBody ResetInfo resetInfo) {
        return resetPassword(resetInfo.getEmail(), resetInfo.getCode(), Integer.valueOf(resetInfo.getPassword()));
    }

    @RequestMapping(value = "/get/mail", method = RequestMethod.GET)
    public Result getEmail(@RequestParam String email) {
        return mailService.sentMail(email);
    }
}
