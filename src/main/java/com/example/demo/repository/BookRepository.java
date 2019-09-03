package com.example.demo.repository;
import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);

    @Query("select u from Book u where (:title is null or u.title = :title)" +
            "and (:author is null or u.author= :author)")
    List<Book> search (@Param("title") String title,
                       @Param("author") String author);

}
