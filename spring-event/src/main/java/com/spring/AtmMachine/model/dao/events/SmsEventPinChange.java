package com.spring.AtmMachine.model.dao.events;

import org.springframework.context.ApplicationEvent;

public class SmsEventPinChange extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SmsEventPinChange(Object source) {
        super(source);
    }
}
