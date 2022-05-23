package com.bookshelf.entities;

import javax.persistence.Entity;

@Entity
public class Rating {
    private Integer rating;
    private Long book_id;
}
