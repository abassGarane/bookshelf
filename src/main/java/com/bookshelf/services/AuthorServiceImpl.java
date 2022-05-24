package com.bookshelf.services;

import java.util.List;

import com.bookshelf.entities.Authors;
import com.bookshelf.repos.AuthorsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorsRepo authorsRepo;

    @Autowired
    public AuthorServiceImpl(AuthorsRepo authorsRepo) {
        this.authorsRepo = authorsRepo;
    }

    @Override
    public List<Authors> getAllAuthors() {
        return authorsRepo.findAll();
    }

    @Override
    public Authors findAuthorById(Long id) {
        return authorsRepo.findById(id).get();
    }

}
