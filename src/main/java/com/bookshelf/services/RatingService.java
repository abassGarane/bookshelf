package com.bookshelf.services;

import com.bookshelf.entities.Rating;

import org.springframework.stereotype.Service;

@Service
public interface RatingService {
    Rating saveRating(Rating rating);
}
