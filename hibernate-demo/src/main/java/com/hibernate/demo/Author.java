package com.hibernate.demo;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


@NamedQuery(name = "user.byId", query = "from Author where id = :id")
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)        //QUES9
    private int id;
    @Column(name = "fName")                               //QUES 6
    private String firstName;
    @Column(name = "lName")                               //QUES 6
    @Transient
    private String lastName;
    @Column(name = "currentAge")                          //QUES 6
    private int age;
    @Column(name = "DOB")                                 //QUES 6
    @Temporal ( TemporalType.DATE )                       //QUES8
    private Calendar Date_of_birth;


    @Embedded                                             ////QUES11
    private Address address;

    @ElementCollection
    List<String> Subject;                                 //QUES12


    //Question 15
    //    @OneToOne
//    Book book;
//    public Book getBook() {
//        return book;
//    }
//
//    public Author setBook(Book book) {
//        this.book = book;
//        return this;
//    }

    @OneToMany(mappedBy = "author")
    private List<Book> book;

    public List<Book> getBook() {
        return book;
    }

    public Author setBook(List<Book> book) {
        this.book = book;
        return this;
    }



    public int getId() {
        return id;
    }

    public Author setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Author setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Author setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Author setAge(int age) {
        this.age = age;
        return this;
    }

    public Calendar getDate_of_birth() {
        return Date_of_birth;
    }

    public Author setDate_of_birth(Calendar date_of_birth) {
        Date_of_birth = date_of_birth;
        return this;
    }



    public Address getAddress() {
        return address;
    }

    public Author setAddress(Address address) {
        this.address = address;
        return this;
    }

    public Author setSubject(List<String> subject) {
        Subject = subject;
        return this;
    }

    public List<String> getSubject() {
        return Subject;
    }



    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", Date_of_birth=" + Date_of_birth +
                ", address=" + address +
                ", Subject=" + Subject +
                '}';
    }
}
