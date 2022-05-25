package com.bookshelf.controllers;

import com.bookshelf.entities.Book;
import com.bookshelf.entities.Rating;
import com.bookshelf.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BooksController {
    private BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
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
        return "create_book";
    }

    @PostMapping("/books")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        Rating rating = new Rating();
        book.setRating(rating);
        rating.setRating(4);
        bookService.saveBook(book);
        return "redirect:/";
    }
}
