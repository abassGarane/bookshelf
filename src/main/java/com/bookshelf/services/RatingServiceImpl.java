package com.bookshelf.services;

import com.bookshelf.entities.Rating;
import com.bookshelf.repos.RatingsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingsRepo ratingsRepo;

    @Autowired
    public RatingServiceImpl(RatingsRepo ratingsRepo) {
        this.ratingsRepo = ratingsRepo;
    }

    @Override
    public Rating saveRating(Rating rating) {
        return ratingsRepo.save(rating);
    }

}
