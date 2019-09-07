package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    //controler do logowania sie na prawidłowa strone
    @GetMapping("/logowanie")
    public String loginForm() {

        return "book-userLogin";
    }
}
