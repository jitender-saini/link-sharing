package linksharing

class MailTriggerJob {
    static triggers = {
      simple name: 'mySimpleTrigger', startDelay: 60000,repeatInterval: 5000l // execute job once in 5 seconds
    }

    def group = "MyGroup"
    def description = "Example job with Simple Trigger"

    def execute() {
        println "Trigger fired"
    }
}
