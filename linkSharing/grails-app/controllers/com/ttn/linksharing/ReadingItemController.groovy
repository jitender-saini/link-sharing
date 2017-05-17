package com.ttn.linksharing

import com.ttn.linkSharing.ReadingItem
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.User

class ReadingItemController {

    def toggleIsRead(Long id) {
        User user = session.user
        Resource resource = Resource.get(id)
        if (user && resource) {
            ReadingItem readingItem = ReadingItem.findByResourceAndUser(resource, user)
            if (readingItem) {
                readingItem.isRead = !readingItem.isRead
            } else {
                readingItem = new ReadingItem(resource: resource, user: user, isRead: true)
            }
            if (readingItem.save(flush:true)) {
                flash.message = "Status updated"
            } else {
                flash.error = readingItem.errors.allErrors.collect { message(error: it) }.join('<br/>')
            }
            redirect(controller: 'user', action: 'index', id: resource.topic.id)
        } else {
            redirect(controller: 'user', action: 'index', id: resource.topic.id)

        }
    }

}