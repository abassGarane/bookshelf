package com.bookshelf.repos;

import com.bookshelf.entities.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepo extends JpaRepository<Book, Long> {

}
