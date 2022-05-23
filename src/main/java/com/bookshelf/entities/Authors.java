package com.bookshelf.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String author_photo_url;

    private String author_website_url;

    private String lastName;

    @ManyToMany(mappedBy = "book_authors")
    private List<Book> books;

    public Authors() {
    }

    public Authors(String firstName, String author_photo_url, String author_website_url, String lastName,
            List<Book> books) {
        this.firstName = firstName;
        this.author_photo_url = author_photo_url;
        this.author_website_url = author_website_url;
        this.lastName = lastName;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAuthor_photo_url() {
        return author_photo_url;
    }

    public void setAuthor_photo_url(String author_photo_url) {
        this.author_photo_url = author_photo_url;
    }

    public String getAuthor_website_url() {
        return author_website_url;
    }

    public void setAuthor_website_url(String author_website_url) {
        this.author_website_url = author_website_url;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
