package linksharing

import com.ttn.linkSharing.LinkResource
import com.ttn.linkSharing.Resource

class TestTagLib {
    def isLoggedIn = { attrs, body ->
        if (session.user) {
            out << body()
        }

    }

    def checkResourceType = { attrs ->
        if (session.user) {
            log.info(" $session.user")
            Resource resource = Resource.get(attrs.resourceId)
            if (resource instanceof LinkResource)

                out << "<span><a href='${resource.url}' target='_blank'>View Full Site</a></span> "
            else out << "<span><a href='${resource.filePath}' target='_blank'>Download</a></span> "
        } else out << ""
    }

}
