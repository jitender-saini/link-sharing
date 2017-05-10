package com.ttn.linksharing


class ApplicationInterceptor {
    ApplicationInterceptor() {
//        matchAll().excludes(controller: 'login')
    }

    boolean before() {
        if (!(session.user)) {
            redirect(controller: "login", action: "index")
            return false
        }
        else return true
    }

    boolean after() {
        log.info "param: ${params}"
        return true
    }

    void afterView() {
        // no-op
    }
}
