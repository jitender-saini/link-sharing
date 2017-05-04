package com.ttn.linksharing


class ApplicationInterceptor {
    ApplicationInterceptor() {
        matchAll().excludes(controller: 'login')
    }

    boolean before() {
        if (!(session['user'])) {
            redirect(controller: "login", action: "index")
            response.status = 500
            return false
        }
        else return true
    }

    boolean after() {
        log.info "action: ${actionName} param: ${params}"
        return true
    }

    void afterView() {
        // no-op
    }
}
