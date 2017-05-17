package com.spring.AtmMachine;

import com.spring.AtmMachine.model.Account;
import com.spring.AtmMachine.model.Sms;
import com.spring.AtmMachine.model.dao.Otp;
import com.spring.AtmMachine.model.dao.events.SmsEvent;
import com.spring.AtmMachine.model.dao.events.SmsEventNumberChange;
import com.spring.AtmMachine.model.dao.events.SmsEventPinChange;
import com.spring.AtmMachine.model.dao.events.SmsFailureEvents;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Component
@Async
public class SmsListener implements ApplicationListener<ApplicationEvent> {

    private static Logger logger = Logger.getLogger(SmsListener.class);
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event.getSource() instanceof Sms) {
            Sms sms = (Sms) event.getSource();
            System.out.println("SMS listener");
            if (event instanceof SmsEvent) {
                successfulTransaction(sms);
            } else if (event instanceof SmsFailureEvents) {
                failureTransaction(sms);
            }
            if(event instanceof SmsEventPinChange){
                logger.info("Dear customer pin of your ATM is changed successfully");
            }
            if (event instanceof SmsEventNumberChange){
                logger.info("Dear customer, your new mobile number is updated");
            }
        }
            if(event.getSource() instanceof Otp){
                Otp otp = (Otp) event.getSource();
                generateOTP(otp);
            }
    }

    @Async
    private void successfulTransaction(Sms sms){
        logger.info("Execute method asynchronously. " + Thread.currentThread().getName());
        try {
            logger.info("successfull transaction and sleeping for 3secs");
            Thread.sleep(3000);
            logger.info("sleep over");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("Dear Customer, You have made a Debit card transaction of INR " + sms.getAmountDebited() +
                " on " + sms.getDate() + "\n, the net available balance in your Ac XXXXXXXXXX" + sms.getId() + " is INR " +
                sms.getAmountLeft());
    }

    @Async
    private void failureTransaction(Sms sms) {

        logger.info("Dear Customer, You tried to make a Debit card transaction of INR " + sms.getAmountDebited() +
                " on " + sms.getDate() + "\n, the net available balance in your Ac XXXXXXXXXX" + sms.getId() + " is INR " +
                sms.getAmountLeft() + "." +
                " Please try with amount less than balance left in account");
    }

    @Async
    private void generateOTP(Otp otp){

        logger.info("Dear Customer, OTP for your transaction is :"+ otp.getOtp());


    }
}
