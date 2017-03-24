package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

//        Employee employee1 = new Employee();
//        employee1.setId(1);
//        employee1.setName("Emp 1");
//        session.save(employee1);

        Author author = new Author();
        author.setId(101);
        author.setFirstName("Jay");
        author.setLastName("Saini");
        author.setAge(24);
        session.save(author);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        System.out.println("Hello World 1234 !!!!");
    }
}
