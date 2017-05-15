package com.ttn.linksharing


class LoginInterceptor {
    LoginInterceptor() {
        matchAll().excludes(controller: 'login')
                .excludes(controller: 'resource', action: 'search')
                .excludes(controller: 'topic', action: 'show')
                .excludes(controller: 'resource', action: 'show')
    }

    boolean before() {
        if (!session['user']) {
            redirect controller: "login", action: "index"
        }
        true

    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
