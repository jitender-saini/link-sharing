package com.ttn.linksharing

import com.ttn.linkSharing.User


class ApplicationInterceptor {
    ApplicationInterceptor() {
        match(controller: 'user', action: 'usersList')
        match(controller: 'user', action: 'toggleActive')
    }

    boolean before() {
        User user = session.user
        if (!user.isAdmin)
            redirect(controller: 'user')
        true
    }

    boolean after() {
        log.info "param: ${params}"
        return true
    }

    void afterView() {
        // no-op
    }
}
