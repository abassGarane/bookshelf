package com.bookshelf.services;

import java.util.List;

import com.bookshelf.entities.Book;
import com.bookshelf.repos.BooksRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BooksRepo booksRepo;

    @Autowired
    public BookServiceImpl(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepo.findAll();
    }

}
