package spring

import com.ttn.linkSharing.email.MailService
// Place your Spring DSL code here
beans = {
    mailService(MailService){
        mailMessageBuilderFactory = ref('mailMessageBuilderFactory')
    }
}
