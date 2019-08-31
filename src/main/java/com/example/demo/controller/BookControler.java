package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookControler {

    private final BookService bookService;

    @Autowired
    public BookControler(@Qualifier("DBBookService") BookService bookService){
        this.bookService = bookService;
    }
//    private InMemoryBookService bookService;
//    private List<Book> books;
//    private Book book;
//    {
//        books = new ArrayList<>();
//        books.add(new Book(4l, "Wyrok", "Tom: 1", "34533",
//                2019, "Remigiusz Mróz"));
//        books.add(new Book(8l, "Czysty kod", "Tom: 1", "56645",
//                2019, "Robert C. Martin"));
//        books.add(new Book(7l, "Programista samouk", "Tom: 1", "77645",
//                2015, "Althoff Cory"));
//        books.add(new Book(5l, "Python dla każdego", "Tom: 1", "34645",
//                2012, "Dawson Michael"));
//        books.add(new Book(3l, "Klatka", "Tom: 1", "87645",
//                2013, "Lilja Sigurdardottir"));
//        books.add(new Book(9l, "Flota Alfa", "Tom: 1", "13645",
//                2017, "B.V. Larson"));
//        Collections.sort(books, Comparator.comparing(b -> b.getId()));
//        Collections.sort(books, Comparator.comparing(Book::getId));
//        book = new Book();
//        book.setTitle("Rana");
//        book.setAuthor("Wojciech Chmielarz");
//        book.setYear(2019);
//        book.setDescription("WYSYŁAMY W 24H");
//        book.setIsbn("Tom: 1");
//        book.setId(1l);
//    }

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("redirect:/book-userLogin");
    }

    @GetMapping("book-list")
    public ModelAndView listBook(){
        ModelAndView modelAndView = new ModelAndView("book-list");
        modelAndView.addObject("books", bookService.getBooks());
        return modelAndView;
    }

    @GetMapping("book-detail")
    public ModelAndView bookDetail(@RequestParam("id") Long id){
        ModelAndView modelAndViewBook = new ModelAndView("book-detail");
        modelAndViewBook.addObject("book", bookService.getBook(id));
        return modelAndViewBook;
    }

    @GetMapping("book-userLogin")
    public ModelAndView bookLogin(){
       return new ModelAndView("book-userLogin");
    }

    @GetMapping("book-userRegistration")
    public ModelAndView userRegistration(){
        return new ModelAndView("book-userRegistration");
    }


//    @GetMapping("/")
//    public ModelAndView forward() {
//        return new ModelAndView("forward:/books");  !! never add commented code !!
//    }

    @GetMapping("book-add")
    public ModelAndView updateBook() {
        ModelAndView modelAndView = new ModelAndView("book-add");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("book-add")
    public ModelAndView addBook(@ModelAttribute Book book){
        bookService.addBook(book);
        return new ModelAndView("redirect:/book-list");
    }
//    @PostMapping("add-book")
//    public ModelAndView addBook(@ModelAttribute Book book) {
//        ModelAndView modelAndView = new ModelAndView("redirect:/book-list");
//        bookService.addBook(book);
//        modelAndView.addObject("book", new Book());
//        return modelAndView;
//    }

    @PostMapping("delete-book")
    public ModelAndView deleteBook(@ModelAttribute Book book){
        bookService.removeBook(book.getId());
        return new ModelAndView("redirect:/book-list");
    }

//    @GetMapping("/book-userRegistration")
//    public String userRegistrationGet(Model modelUser){
//        modelUser.addAttribute("user", new User());
//        return "book-userRegistration";
//    }
//
//    @PostMapping("/book-sukcesUserRegistration")
//    public String userRegistrationPost(@ModelAttribute User user){
//        return "book-sukcesUserRegistration";
//    }
}
