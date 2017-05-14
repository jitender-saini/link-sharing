package com.ttn.linkSharing

import com.ttn.linkSharing.co.UserCO
import grails.transaction.Transactional

@Transactional
class UserService {

    def registration(UserCO userCo) {
        User user = new User(userCo.properties)
        user.save(flush: true)
        return !user.hasErrors()
    }
}