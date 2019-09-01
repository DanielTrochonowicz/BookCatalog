package com.example.demo.repository;
import com.example.demo.model.Book;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);

    @Query("select u from Book u where u.title=?1 and u.author=?2")
    List<Book> search (String title, String author);

}
