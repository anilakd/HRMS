package com.kodlamaio.hrmsdemo.hrmsdemo.api.controllers;


import com.kodlamaio.hrmsdemo.hrmsdemo.business.abstracts.LoginService;
import com.kodlamaio.hrmsdemo.hrmsdemo.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {

    private final LoginService loginService;


    @Autowired
    LoginController(LoginService loginService){
        this.loginService=loginService;
    }

    @PostMapping
    public Result login(@RequestParam String email, String password){
        return this.loginService.login(email, password);
    }

}
