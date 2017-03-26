package com.hibernate.demo;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.LockModeType;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class Application {

    public static void main(String[] args) {

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        List<AuthorDto> authorDtoList = session.createQuery("select new com.hibernate.demo.AuthorDto(firstName,age) from Author").list();
        authorDtoList.forEach(System.out::println);

//        Map map = new HashMap<Integer,String>;
//        map.put(24,"male");

        //2. Using HQL print all the records of Author
        /*Query query =session.createQuery("from Author");
        List<Author> authorList = (List<Author>)query.getResultList();
        authorList.forEach(System.out::println);*/

        /*Query query =session.createQuery("select firstName from Author where age > ? " +"where gender = male ").setParameter(0,24);
        List<Author> authorList = (List<Author>)query.getResultList();
        //authorList.forEach(System.out::println);
        System.out.println(authorList);*/

        //Update a Author name with id 3 using HQL
//        Query query =session.createQuery("update Author set age = 22 where id = ? ").setParameter(0,103);
//        query.executeUpdate();

        //Delete Author with id 4 using HQL.
//        Query query =session.createQuery("delete Author where id = ? ").setParameter(0,104);
//        query.executeUpdate();

//        Demo demo = new Demo();
//        demo.setId(201);
//        demo.setFirstName("DemoName");
//        demo.setAge(55);
//        demo.setGender("Female");
//        session.save(demo);

        //Save one record for demo entity now insert using HQL from Demo to Author Entity.
//        Query query = session.createQuery("INSERT INTO Author(id, firstName, age, gender) SELECT id, firstName, age, gender FROM Demo"
//                +" where id = ?").setParameter(0,201);
//        query.executeUpdate();

        //Print few records of Author using pagination.
//        Query query = session.createQuery("from Author");
//        query.setFirstResult(1);
//        query.setMaxResults(5);
//        List<Author> authorList = query.list();
//        authorList.forEach(System.out::println);

        //Perform one query in HQL using Named Query
//        Query query = session.createNamedQuery("user.byId").setParameter("id",103);
//        System.out.println(query.uniqueResult());

//        Query query = session.createNativeQuery("select * from Author");
//        List<Object []> authorList = query.list();
//        authorList.forEach(System.out::println);

//        Query query = session.createNativeQuery("delete from Author where id = 106").addEntity(Author.class);
//        System.out.println(query.executeUpdate());

//        Query query = session.createNativeQuery("UPDATE Author set age = 101 where id =201").addEntity(Author.class);
//        System.out.println(query.executeUpdate());


//        Author author1 = new Author();
//        authorList.forEach(author -> {
//            System.out.println(author1.getId());
//            System.out.println(author1.getFirstName());
//            System.out.println(author1.getAge());
//            System.out.println(author1.getGender());
//        });

//        Author author = session.get(Author.class,101);
//        author.setFirstName("Updated");
//        author.setLastName("Name");
//        session.update(author);

        //Author author = new Author(1,"Jay",24,"male");
//        Author author = new Author();
//        author.setId(101);
//        author.setFirstName("Jay");
//        author.setGender("male");
//        author.setAge(24);
//        session.save(author);

//  {      Author author2 = new Author();
//        author2.setId(102);
//        author2.setFirstName("Ajay");
//        author2.setGender("Male");
//        author2.setAge(23);
//        // author.setDateOfBirth("1991/11/14");
//        session.save(author2);
//
//        Author author3 = new Author();
//        author3.setId(103);
//        author3.setFirstName("Divyansh");
//        author3.setGender("Male");
//        author3.setAge(24);
//        // author.setDateOfBirth("1991/11/14");
//        session.save(author3);
//
//        Author author4 = new Author();
//        author4.setId(104);
//        author4.setFirstName("Ishwar");
//        author4.setGender("Male");
//        author4.setAge(16);
//        // author.setDateOfBirth("1991/11/14");
//        session.save(author4);
//
//        Author author5 = new Author();
//        author5.setId(105);
//        author5.setFirstName("akhil");
//        author5.setGender("Male");
//        author5.setAge(45);
//        // author.setDateOfBirth("1991/11/14");
//        session.save(author5);
//
//        Author author6 = new Author();
//        author6.setId(106);
//        author6.setFirstName("Shefali");
//        author6.setGender("female");
//        author6.setAge(24);
//        // author.setDateOfBirth("1991/11/14");
//        session.save(author6);}

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        readDB();
    }

    private static void readDB(){
        String queryString = "select e " +
                "from Employee e " +
                "where e.deptId = :deptId";
        Thread t = new Thread();
        t.start();

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query = session.createQuery(
                queryString, Employee.class)
                .setParameter("deptId", "JVM")
                .setLockMode(LockModeType.PESSIMISTIC_READ);

        session.beginTransaction();

        Employee employee = (Employee) query.getSingleResult();
        System.out.println(employee.toString());

        //sleep(2000);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    /*void writeDB(){
        String queryString = "select e " +
                "from Employee e " +
                "where e.deptId = :deptId";
        Thread t = new Thread();
        t.start();

        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(
                queryString, Employee.class)
                .setParameter("deptId", "JVM")
                .setLockMode(LockModeType.PESSIMISTIC_WRITE);
        session.beginTransaction();

        Employee employee = query.getSingleResult();

        employee.setName("changed");
        session.save(employee);

        session.getTransaction().commit();
    }*/
}
