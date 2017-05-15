package com.ttn.linkSharing

import com.ttn.linkSharing.co.UpdateProfileCO
import com.ttn.linkSharing.co.UserCO
import grails.transaction.Transactional

//@Transactional
class UserService {

    def registration(UserCO userCo) {
        User user = new User(userCo.properties)
        user.save(flush: true)
        return !user.hasErrors()
    }

    def updateUser(User userObj, UpdateProfileCO profileCO) {
        userObj.firstName = profileCO.firstName
        userObj.lastName = profileCO.lastName
        userObj.userName = profileCO.userName
        userObj.profilePic = profileCO.profilePic
        if (userObj.validate()) {
            userObj.merge(flush: true)
            return !userObj.hasErrors()
        }
    }

    def updatePassword(User userObj, UpdateProfileCO profileCO) {
        if (profileCO.password == profileCO.confirmPassword && profileCO.password.length()>5){
            userObj.executeUpdate("update User as U set U.password=:password where U.id=:id",
                    [password: profileCO.password, id: userObj.id])
        }
        return !userObj.hasErrors()
    }
}