package com.example.demo.service;
import com.example.demo.model.Book;
import java.util.List;

public interface BookService {

   List<Book> getBooks();

   Book getBook(Long bookId);

   void removeBook(Long id);

   Book addBook(Book book);
}
