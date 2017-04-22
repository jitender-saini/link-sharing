package com.ttn.mocking

import com.ttn.groovy.User
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Unroll

class UserSpec extends Specification {

    def "First test"() {
        expect:
        true
    }

    @Unroll
    def "We are able to get the maximum of the two numbers"() {
        when:
        Integer result = Math.max(x, y)

        then:
        result == z

        where:
        x | y  || z
        1 | 2  || 2
        5 | 10 || 10
        0 | 0  || 0
    }


   void "After updating the password of a user we send a reset password email containing the new password"(){

       given: "A user with an old password"
       User user = new User(password: 'oldPassword')

       and: "Mocked EmailService"
       def emailService = Mock(EmailService)
       user.emailService = emailService

       when: "When updatePassword is called"
       user.updatePassword("newPassword")

       then:
       user.password == "newPassword"
       1 * emailService.sendPasswordResetEmail(user, "newPassword")
       0 * emailService.sendPasswordResetFailureEmail(user, "newPassword")
   }

    void "Encrypt passsord should return encrypted password after validating the passsword"(){
        given: "A user"
        User user = new User()

        and: "Mock PasswordEncrypterService"

        def passwordEncrypterService = Mock(PasswordEncrypterService)
        user.passwordEncrypterService = passwordEncrypterService

        when:
        String encrypted = user.encyryptPassword("password")

        then:
        1 * passwordEncrypterService.encrypt("password") >> {args->
            if(args[0]=="password"){
                return "1234567"
            }else{
                return "abcdefghi"
            }
        }
        encrypted == "1234567"
    }

    @IgnoreRest
    void "Sorted interested in categoris are returned"(){
        given:
        User user = Spy(User)
        List dummyCategories = ["movies", "social-networking"]

        when:
        List<String> interestedInCategories = user.getSortedInterestedInCategories()

        then:
        1 * user.getInterestedInCategories() >> dummyCategories
        interestedInCategories == dummyCategories
    }
}
