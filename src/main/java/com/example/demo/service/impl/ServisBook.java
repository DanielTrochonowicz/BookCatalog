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

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<Book> search(){
        return bookRepository.findAll();
    }

    public List<Book> searchBook(String searchText, String searchParameter){
        switch (searchParameter){
            case "Title":
                return  bookRepository.findByTitle(searchText);
            case "Author":
                return bookRepository.findByAuthor(searchText);
            default:
                return bookRepository.findAll();
        }
    }
}
