package demo

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message
import grails.converters.JSON
import grails.converters.XML
import org.codehaus.groovy.tools.shell.util.MessageSource

class TestController {

//    static responseFormats = ["json","xml"]
//    static defaultAction = "testAction"

//    static allowedMethods = [testAction: ]

    def testAction() {
//        render "test"
//        Map map = ["test":2,"abc":2]
//        render map as JSON
        render "${controllerName}/${actionName}"

//        params
    }

    def test(){
        render "hello friends"
    }

    def save() {
        response.sendError(404)
    }

    def index() {
//        render "Params ${params} ${session.name}"
//2 action implicit chaining, interceptors called twice demo
        redirect(action: "renderText", params: [actionName         : actionName,
                                               firstInterceptorRan: params.firstInterceptorRan])
    }
    MessageSource messageSource

    def msgs(){
        String message = messageSource.getMessage("default.show.label",["text"] as Object[], Locale.getDefault())
         message += messageSource.getMessage("hello japan",null, Locale.JAPANESE())
    }

    String renderText(){
        render "Params ${params}"
    }
}
