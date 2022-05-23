package com.bookshelf.services;

import java.util.List;

import com.bookshelf.entities.Book;

import org.springframework.stereotype.Service;

@Service
public interface BookService {
    List<Book> getAllBooks();
}
