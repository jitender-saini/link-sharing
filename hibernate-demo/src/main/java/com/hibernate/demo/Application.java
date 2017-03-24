package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Author author = session.get(Author.class,101);
        author.setFirstName("Updated");
        author.setLastName("Name");
        session.update(author);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
