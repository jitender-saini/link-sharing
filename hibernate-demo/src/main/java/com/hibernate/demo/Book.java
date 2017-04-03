package com.hibernate.demo;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
//QUES14
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int bookID;
    String bookName;

    @ManyToOne
    Author author;

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
}
