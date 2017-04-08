package com.spring.employeeEvents;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class EmployeeListener implements ApplicationListener <EmployeeEvent> {
    @Override
    public void onApplicationEvent(EmployeeEvent event) {
        if(event.getSource() instanceof Employee){
            Employee employee = (Employee) event.getSource();

            SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            session.close();
            sessionFactory.close();
        }
    }
}
