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

    private int bookID;
    private String bookName;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> author;

    public Book setAuthor(List<Author> author) {
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
