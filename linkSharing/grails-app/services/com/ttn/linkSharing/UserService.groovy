package com.ttn.linkSharing

import com.ttn.linkSharing.co.UserCO
import grails.transaction.Transactional

@Transactional
class UserService {

    def registration(UserCO userCo) {
        User user = new User(userCo.properties)
        if (user.save(flush: true, failOnErron: true)) {
            println "user register called"
            return true
        } else {
            println "user register failed"
            return false
        }
    }
}