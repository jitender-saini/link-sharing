package com.ttn.linkSharing.email

import grails.config.Config
import grails.plugins.mail.MailMessageBuilder
import org.springframework.mail.MailMessage

class MailService extends grails.plugins.mail.MailService {

    @Override
    MailMessage sendMail(Config config, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = MailMessageBuilder) Closure callable) {
        if (isDisabled()) {
            log.warn("Sending emails disabled by configuration option")
            return
        }
        println "Sending Mail"
        MailMessageBuilder messageBuilder = mailMessageBuilderFactory.createBuilder(config)
        callable.delegate = messageBuilder
        callable.resolveStrategy = Closure.DELEGATE_FIRST
        callable.call(messageBuilder)
        println "mail sent"
        return messageBuilder.sendMessage(mailExecutorService)
    }

    boolean isDisabled() {
        configuration.getProperty('grails.mail.disabled',Boolean, false)
    }
}
