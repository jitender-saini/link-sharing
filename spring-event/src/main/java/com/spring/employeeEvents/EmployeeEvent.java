package com.spring.employeeEvents;

import org.springframework.context.ApplicationEvent;

public class EmployeeEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public EmployeeEvent(Object source) {
        super(source);
    }
}
