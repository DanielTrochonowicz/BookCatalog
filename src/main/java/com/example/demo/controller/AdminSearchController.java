package com.example.demo.controller;
import com.example.demo.service.impl.ServisBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
//@RequestMapping(value = "/admin")  przy wyszukiwaniu usera dodac sobie to
public class AdminSearchController {

    @Autowired
    private ServisBook servisBook;

    @GetMapping("book-serchBook")
    public ModelAndView searchBook( ){
        ModelAndView modelAndView = new ModelAndView("book-searchBook");
        modelAndView.addObject("books", servisBook.search());
        return modelAndView;
    }
//    findAll()
    @PostMapping("book-list")
    public String serchBook(@RequestParam String searchText,
                            @RequestParam String searchParameter, Model model){

        model.addAttribute("books", servisBook.search());
            return "book-list";
        }
}