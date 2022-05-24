package com.bookshelf.repos;

import com.bookshelf.entities.Authors;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsRepo extends JpaRepository<Authors, Long> {

}
