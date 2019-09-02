package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("/book-userRegistration")
    public String userRegistration(Model model) {
        model.addAttribute("user", new User());
        return "book-userRegistration";
    }

    @PostMapping("/book-userRegistration")
    public String courseSuccess(@Valid @ModelAttribute User user,
                                BindingResult bindingResult, Model model) {
        model.addAttribute("user", user);
        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            return "book-userRegistration";
        }
        userService.save(user);
        return "book-sukcesUserRegistration";
    }

//    @GetMapping("book-userRegistration")
//    public ModelAndView userRegistration(){
//        ModelAndView modelAndView = new ModelAndView("book-userRegistration");
//        modelAndView.addObject("user", new User());
//        return modelAndView;
//    }

    @PostMapping("/book-sukcesUserRegistration")
    public String userRegistrationPost(@ModelAttribute User user){
        userService.save(user);
        return "book-sukcesUserRegistration";
    }
}
