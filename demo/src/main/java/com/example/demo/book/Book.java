package com.example.demo.book;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name="book_s",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,generator = "book_sequence"
    )
    private String title;
    private LocalDate dateSince;
    private Long bookID;
    private String author;
    public Book() {
    }

    public Book(String title, LocalDate dateSince, Long bookID, String author) {
        this.title = title;
        this.dateSince = dateSince;
        this.bookID = bookID;
        this.author = author;
    }

    public Book(String title, LocalDate dateSince,String author) {
        this.title = title;
        this.dateSince = dateSince;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateSince() {
        return dateSince;
    }

    public void setDateSince(LocalDate dateSince) {
        this.dateSince = dateSince;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", dateSince=" + dateSince +
                ", bookID=" + bookID +
                ", author='" + author + '\'' +
                '}';
    }
}
