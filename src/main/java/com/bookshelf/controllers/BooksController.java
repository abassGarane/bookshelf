package com.bookshelf.controllers;

import com.bookshelf.entities.Book;
import com.bookshelf.entities.Rating;
import com.bookshelf.services.BookService;
import com.bookshelf.services.RatingService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BooksController {
    private BookService bookService;
    private RatingService ratingService;

    public BooksController(BookService bookService, RatingService ratingService) {
        this.bookService = bookService;
        this.ratingService = ratingService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "home";

    }

    @GetMapping("/books/{id}")
    public String findBook(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookService.findBookById(id));
        return "book";
    }

    @GetMapping("/books/new")
    public String createBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("rating", new Rating());
        return "create_book";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        Rating rating = new Rating();
        rating.setRating(0);
        Rating ratingSaved = ratingService.saveRating(rating);
        book.setRating(ratingSaved);
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") Long id, Model model){
        System.out.println("called");
        model.addAttribute("book", bookService.findBookById(id));
        return "edit";
    }

    @PostMapping("/books/update/{id}")
    public String updateBook(@PathVariable("id") Long id, @ModelAttribute("book") Book book){

        Book old  = bookService.findBookById(id);
        Rating rating = new Rating();
        rating.setRating(old.getRating().getRating());
        BeanUtils.copyProperties(book, old);
        old.setRating(rating);
        bookService.updateBook(old);
        return "redirect:/books/{id}";
    }
}
