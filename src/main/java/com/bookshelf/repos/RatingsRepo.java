package com.bookshelf.repos;

import com.bookshelf.entities.Rating;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepo extends JpaRepository<Rating, Long> {

}
