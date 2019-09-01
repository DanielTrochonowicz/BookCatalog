package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {


    @Autowired
    private  UserService userService;

    @GetMapping("book-userRegistration")
    public ModelAndView userRegistration(){
        ModelAndView modelAndView = new ModelAndView("book-userRegistration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }


    @PostMapping("/book-sukcesUserRegistration")
    public String userRegistrationPost(@ModelAttribute User user){
        userService.save(user);
        return "book-sukcesUserRegistration";
    }
}
