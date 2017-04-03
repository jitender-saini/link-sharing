package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

////        Q2 crud-create
//        Author author = new Author();
//        author.setFirstName("Jay");
//        author.setLastName("Saini");
//        author.setAge(24);
//        author.setGender("Male");
//        session.save(author);
//
////        Q2 curd read
//        Author author1 = session.get(Author.class,1);
//        System.out.println(author1);
//
////        Q2 curd update
//        Author author2 = session.get(Author.class,1);
//        author2.setAge(25);


        //Q3
//        Author author3 = new Author ();
//        author3.setId(1);
//        author3.setFirstName ("Jay ");
//        author3.setLastName ( "Saini" );
//        author3.setAge (25);
//        author3.setDate_of_birth ( new GregorianCalendar(1991,11,14));
//        session.save(author3);




        Address address = new Address ();
        address.setState ( "New Delhi" );
        address.setLocation ( "Mundka" );
        address.setStreetNo (5);

        Book book = new Book();
        book.setBookName("Java");
//        book.setAuthor(author2);
        session.save(book);

        Book book2 = new Book();
        book2.setBookName("JS");
        session.save(book2);


        Book book3 = new Book();
        book3.setBookName("jQuery");
        session.save(book3);


        List <Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);


        Author author2 = new Author ();
        author2.setFirstName ("Jay");
        author2.setLastName ( "Saini" );
        author2.setAge ( 25 );
        author2.setDate_of_birth ( new GregorianCalendar (1991,11,14));
        author2.setSubject ( Arrays.asList ( "Java","cSharp","Data Structure") );               //QUES13
        author2.setAddress ( address );
        author2.setBook(bookList);
        session.save(author2);

//        Author author4 = new Author ();
//        author4.setFirstName ("Shefali");
//        author4.setLastName ( "Sharma" );
//        author4.setAge ( 23 );
//        author4.setDate_of_birth ( new GregorianCalendar(1993,07,02));
//        author4.setSubject ( Arrays.asList ( "java","AEM","Jquery") );               //QUES13
//        author4.setAddress ( address );
////        author4.setBook(book);
//        author4.setBook(bookList);
//        session.save(author4);
//
//
//
//        Author author5 = new Author ();
//        author5.setFirstName ("Ajay");
//        author5.setLastName ( "Goel" );
//        author5.setAge ( 24 );
//        author5.setDate_of_birth ( new GregorianCalendar(1993,07,02));
//        author5.setSubject ( Arrays.asList ( "JS","Spring","Hibernate") );               //QUES13
//        author5.setAddress ( address );
////        author5.setBook(book);
//        author5.setBook(bookList);
//        session.save(author5);


        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }


}
