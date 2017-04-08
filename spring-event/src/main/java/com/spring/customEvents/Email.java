package com.spring.customEvents;

public class Email {
    private String toMail;
    private String fromMail;
    private String subject;
    private String body;

    public String getToMail() {
        return toMail;
    }

    public Email setToMail(String toMail) {
        this.toMail = toMail;
        return this;
    }

    public String getFromMail() {
        return fromMail;
    }

    public Email setFromMail(String fromMail) {
        this.fromMail = fromMail;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public Email setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Email setBody(String body) {
        this.body = body;
        return this;
    }
}
