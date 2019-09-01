package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

// http://localhost:8087/h2-console  do połaczenia z baza danych
// jdbc:h2:mem:testdb

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 9000)
    private String description;

    @Column(length = 500)
    private String title;
    private String isbn;
    private Integer year;
    @Column(length = 500)
    private String author;

    public Book(Long id, String title, String isbn, String description, Integer year, String author) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.year = year;
        this.author = author;
    }

    public Book(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book" +
                "Id=" + id +
                "Title: " + title + '\'' +
                "Isbn: " + isbn + '\'' +
                "Description: " + description + '\'' +
                "Year: " + year + '\'' +
                "Author: " + author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(description, book.description) &&
                Objects.equals(year, book.year) &&
                Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, description, year, author);
    }
}