package com.ttn.linksharing


class ApplicationInterceptor {

    boolean before() {
        if(!(session['user'])){
            redirect(controller:"login",action:"index")
            false
        }
        else true
    }

    boolean after() {
        log.info "action: ${actionName} param: ${params}"
        true }

    void afterView() {
        // no-op
    }
}
