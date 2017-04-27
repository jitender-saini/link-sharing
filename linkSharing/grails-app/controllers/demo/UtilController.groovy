package demo

class UtilController {

    def index() {
        println "Debug log enabled?: " + log.debugEnabled
        log.debug "Debug log"
        log.info "Info log"
        log.error "Error log"
        log.warn "Warning level"
        log.trace "Trace log"
        log.fatal "Fatal error log"
    }
}
