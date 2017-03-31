package com.spring.customEvents;

import org.springframework.context.ApplicationListener;

public class EmailListener implements ApplicationListener<EmailEvent> {
    @Override
    public void onApplicationEvent(EmailEvent event) {
        if(event.getSource() instanceof Email){
            Email email = (Email) event.getSource();
            System.out.println("Email is sent to: "+email.getToMail()+"\nfrom: "+email.getFromMail()+
            "\nSubject: "+email.getSubject());

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\nBody: "+email.getBody());
        }
    }
}
