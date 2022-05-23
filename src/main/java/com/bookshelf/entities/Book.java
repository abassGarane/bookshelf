package com.bookshelf.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String bookPhotoUrl;

    private String shortDesc;

    private String synopsis;

    private Integer numberOfPages;

    private String isbn;

    private String language;

    @Temporal(TemporalType.DATE)
    private Date dateOfPublishing;

    @ManyToMany()
    @JoinTable(name = "books_authors", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Authors> book_authors;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    public Book() {
    }

    public Book(String name, String bookPhotoUrl, String shortDesc, String synopsis, Integer numberOfPages, String isbn,
            String language, Date dateOfPublishing, List<Authors> book_authors, Rating rating) {
        this.name = name;
        this.bookPhotoUrl = bookPhotoUrl;
        this.shortDesc = shortDesc;
        this.synopsis = synopsis;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.language = language;
        this.dateOfPublishing = dateOfPublishing;
        this.book_authors = book_authors;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookPhotoUrl() {
        return bookPhotoUrl;
    }

    public void setBookPhotoUrl(String bookPhotoUrl) {
        this.bookPhotoUrl = bookPhotoUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getDateOfPublishing() {
        return dateOfPublishing;
    }

    public void setDateOfPublishing(Date dateOfPublishing) {
        this.dateOfPublishing = dateOfPublishing;
    }

    public List<Authors> getBook_authors() {
        return book_authors;
    }

    public void setBook_authors(List<Authors> book_authors) {
        this.book_authors = book_authors;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
