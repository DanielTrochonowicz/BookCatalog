package com.example.demo.service.impl;


import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServisBook {

    @Autowired
    private BookRepository bookRepository;

//    public void save(Book book){
//        servisBook.save(book);
//    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }
}
