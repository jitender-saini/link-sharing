package com.ttn.linksharing

import com.ttn.linkSharing.User

class LoginController {

    def index() {
        User user = User.get(1)
        if(session instanceof User)
            render "Hello"
    }

    def loginHandler(){

    }

    def logout(){

    }

}
