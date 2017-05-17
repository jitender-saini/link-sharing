package com.ttn.mocking

import com.ttn.groovy.PasswordEncrypterService
import spock.lang.Specification

class PasswordEncrypterServiceSpec extends Specification {
    //todo
    def "Encrypted password is returned by the public method"() {
        given:
        PasswordEncrypterService encrypterService =Spy(PasswordEncrypterService)
        
        and :
        1*encrypterService.aVeryComplexProcess("password")>>{
         return "password".reverse()
        }
        when:
        String encrypt=encrypterService.encrypt("password")
        
        then:
        encrypt=="password".reverse()

    }
}
