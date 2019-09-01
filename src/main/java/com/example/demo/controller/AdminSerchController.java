package com.example.demo.controller;


import com.example.demo.service.impl.ServisBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;



@Controller
//@RequestMapping(value = "/admin")  przy wyszukiwaniu usera dodac sobie to
public class AdminSerchController {

    @Autowired
    private ServisBook servisBook;

    @GetMapping("book-serchBook")
    public ModelAndView serchBook( ){
        ModelAndView modelAndView = new ModelAndView("book-serchBook");
        modelAndView.addObject("books", servisBook.findAll());
        return modelAndView;
    }

}
