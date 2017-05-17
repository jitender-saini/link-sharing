package linksharing

import com.ttn.linkSharing.ReadingItem
import com.ttn.linkSharing.Resource
import com.ttn.linkSharing.User
import com.ttn.linkSharing.dto.EmailDTO
import grails.transaction.Transactional

@Transactional
class EmailService {

    def mailService

    def sendMail(EmailDTO emailDTO) {
        sendMail {
            async true
            to emailDTO.to.tokenize(";")
            subject emailDTO.subject
            if (emailDTO.content) {
                body emailDTO.content
            } else {
                body(view: emailDTO.view, model: emailDTO.model)
            }
        }
    }

    void sendUnreadResourcesEmail() {
        List<User> users = User.getAll()
        users.each {
            List<ReadingItem> readingItemList = ReadingItem.findAllByUserAndIsRead(it, false)
            if (readingItemList) {
                List<Resource> resourceList = readingItemList*.resource
                sendMailNotification(it, resourceList)
            }
        }
    }

    private void sendMailNotification(User user, List<Resource> resourceList) {

        String htmlData = generateHtmlMessage(resourceList)
        try {
            mailService.sendMail {
                multipart true
                to user.email
                subject "Unread Resources - linksharing"
                html """<b>You have some unread resources :$htmlData</b>"""
            }
            log.info(" user : $user notified about unread resources")
        } catch (Exception exception) {
            log.info(" user : $user : error in sending notification $exception")
        }
    }

    private static String generateHtmlMessage(List<Resource> resourceList) {
        StringBuilder builder = new StringBuilder()
        resourceList.each {
            builder.append("<p>Topic : $it.topic , Creator : $it.createdBy , description : $it.description</p></br>")
        }
        builder.toString()
    }
}