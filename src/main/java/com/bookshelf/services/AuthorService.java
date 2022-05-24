package com.bookshelf.services;

import java.util.List;

import com.bookshelf.entities.Authors;

import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    List<Authors> getAllAuthors();

    Object findAuthorById(Long id);
}
