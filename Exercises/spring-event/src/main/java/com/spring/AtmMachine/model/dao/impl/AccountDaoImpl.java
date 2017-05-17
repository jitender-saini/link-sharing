package com.spring.AtmMachine.model.dao.impl;

import com.spring.AtmMachine.SmsPublisher;
import com.spring.AtmMachine.model.Account;
import com.spring.AtmMachine.model.Sms;
import com.spring.AtmMachine.model.dao.AccountDao;
import com.spring.AtmMachine.model.dao.Otp;
import com.spring.AtmMachine.model.dao.events.SmsEvent;
import com.spring.AtmMachine.model.dao.events.SmsEventNumberChange;
import com.spring.AtmMachine.model.dao.events.SmsEventPinChange;
import com.spring.AtmMachine.model.dao.events.SmsFailureEvents;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Random;


public class AccountDaoImpl implements AccountDao {
    private static Logger logger = Logger.getLogger(AccountDaoImpl.class);
    ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("config.xml");

   SmsPublisher smsPublisher = context.getBean("smsPublisher",SmsPublisher.class);
    SmsEvent smsEvent;

    private int userOtp;
    Otp otp;

    public int getUserOtp() {
        return userOtp;
    }

    public AccountDaoImpl setUserOtp(int userOtp) {
        this.userOtp = userOtp;
        return this;
    }


    @Override
    public void checkBalance(int id, int pin) {
        Account account = findAccount(id,pin);
        if(account==null){
            logger.info("Invalid ID");
            return;
        }
            logger.info("Dear Customer, the net available balance in your Ac XXXXXXXXXX is "+account.getBalance());
    }

    @Override
    public void withdrawsAmount(int id, int amount, int pin) {
        Account account = findAccount(id,pin);
        if(account==null){
            return;
        }
        if(account.getBalance() > 0 && account.getBalance() > amount) {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Account account2 = session.get(Account.class, id);
            account2.setBalance(account2.getBalance() - amount);

            session.getTransaction().commit();
            smsEventer(account2,amount,true);
            session.close();
            sessionFactory.close();
        }
        else smsEventer(account,amount,false);
    }

    @Override
    public void change(int id, int oldPin) {
        Account account = findAccount(id, oldPin);
        if (account == null) {
            return;
        }
        eventOTP();
    }


    public void updatePin(int id, int oldPin, int newPin){
        Account account = findAccount(id, oldPin);
        if (account == null) {
            return;
        }
        if(otp.getOtp()==userOtp){
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Account account2 = session.get(Account.class, id);
            account2.setAtmPin(newPin);
            session.getTransaction().commit();
            Sms sms = new Sms();
            SmsEventPinChange pinChange = new SmsEventPinChange(sms);
            smsPublisher.publish(pinChange);
            session.close();
            sessionFactory.close();
        }
        else
            logger.info("invalid OTP");
    }

    @Override
    public void changeMobile(int id, String number, int pin) {
        Account account = findAccount(id, pin);
        if (account == null) {
            return;
        }
        if(otp.getOtp()==userOtp) {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Account account2 = session.get(Account.class, id);
            account2.setMobileNumber(number);

            session.getTransaction().commit();
            Sms sms = new Sms();
            SmsEventNumberChange numberChange = new SmsEventNumberChange(sms);
            smsPublisher.publish(numberChange);
            session.close();
            sessionFactory.close();
        }
        else logger.info("Invalid OTP");
    }

    public Account findAccount(int id, int pin){
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Account account = session.get(Account.class, id);
        if(account==null){
            logger.info("Invalid Id try again!");
        }
        if(account.getAtmPin()!=pin){
            logger.info("Invalid Pin Code try again!");
            return null;
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return account;
    }

    private void smsEventer(Account account, int withdrawalAmount, boolean flag) {

        Sms sms = new Sms();
        sms.setAmountDebited(withdrawalAmount);
        sms.setAmountLeft(account.getBalance());
        sms.setDate(new Date());
        sms.setId(account.getId());
        if (flag) {
            SmsEvent smsEvent = new SmsEvent(sms);
            smsPublisher.publish(smsEvent);
        } else {
            SmsFailureEvents smsFailureEvents = new SmsFailureEvents(sms);
            smsPublisher.publish(smsFailureEvents);
        }
    }

    private void eventOTP(){
        Random rand = new Random();
        otp = new Otp();
        otp.setOtp(100000 + rand.nextInt((999999 - 100000) + 1));
        System.out.println("otp event otp"+otp.getOtp());
        SmsEvent smsEvent = new SmsEvent(otp);
        smsPublisher.publish(smsEvent);
    }
}
