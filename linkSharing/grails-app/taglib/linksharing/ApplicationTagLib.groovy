package linksharing

import com.ttn.linkSharing.ReadingItem
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.User

class ApplicationTagLib {
    static defaultEncodeAs = "raw"

    static namespace = "ls"
    def isRead = { attrs, body ->
        User user = session.user
        if (user) {
            Resource resource = attrs.resource
            if (resource) {
                Integer count = ReadingItem.countByResourceAndIsReadAndUser(resource, true, user)
                if (count) {
                    out << "<a href='${createLink(controller: 'readingItem', action: 'toggleIsRead', id: resource.id)}'>Mark as Un Read</a> "
                } else {
                    out << "<a href='${createLink(controller: 'readingItem', action: 'toggleIsRead', id: resource.id)}'>Mark as Read</a> "
                }
            }
        }
    }

    def isLoggedIn = { attrs, body ->
        if (session.user) {
            out << body()
        }

    }
}

