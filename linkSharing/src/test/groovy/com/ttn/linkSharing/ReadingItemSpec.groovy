package com.ttn.linkSharing

import com.ttn.linkSharing.enums.Visibility
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    @Unroll("#sno")
    void "constraints Of Resource Item Excluding User Uniqueness"() {

        given:
        ReadingItem resourceItem = new ReadingItem(resource: resource, user: user, isRead: isRead)

        when:
        boolean result = resourceItem.validate(['resource', 'user', 'isRead'])

        then:
        result == excepted

        where:
        sno | resource               | user       | isRead | excepted
        1   | Mock(LinkResource)     | Mock(User) | true   | true
        2   | null                   | Mock(User) | true   | false
        3   | Mock(LinkResource)     | null       | true   | false
        4   | Mock(LinkResource)     | Mock(User) | null   | false
        5   | Mock(DocumentResource) | Mock(User) | true   | true
    }

    def "validating Unique Reading Item"() {

        given:
        User user = new User(firstName: "fname", lastName: "lname", email: "email@ttn.com", password: "password",
                userName: "userName", dateCreated: new Date(), lastUpdated: new Date())

        Topic topic = new Topic(topicTitle: "Groovy", description: "desc", visibility: Visibility.PRIVATE,
                createdBy: user, dateCreated: new Date(), lastUpdated: new Date())

        Resource resource = new LinkResource(url: "https://www.tothenew.com/", description: "desc",
                createdBy: user, topic: topic, dateCreated: new Date(), lastUpdated: new Date())



        ReadingItem readingItem = new ReadingItem(resource: resource, user: user, isRead: true)
        ReadingItem newReadingItem = new ReadingItem(resource: resource, user: user, isRead: false)

        when:
        readingItem.save()
        newReadingItem.save()

        then:

        ReadingItem.count() == 1
        newReadingItem.errors.allErrors.size() == 1
        newReadingItem.errors.getFieldErrorCount('resource') == 1

    }
}
