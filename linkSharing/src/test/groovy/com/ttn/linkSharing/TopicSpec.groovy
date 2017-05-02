package com.ttn.linkSharing

import com.ttn.linkSharing.enums.Visibility
import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */

@TestMixin(DomainClassUnitTestMixin)
@Mock([Topic, User])
class TopicSpec extends Specification {

    def "Topic should be unique per user"() {
        setup:
        String topicTitle = "Groovy"
        User user = new User(firstName: "fname", lastName: "lname", email: "email@ttn.com", password: "password", userName: "userName")

        Topic topic = new Topic(topicTitle: topicTitle, description: "groovy lang", createdBy: user, visibility: Visibility.PRIVATE)
        when:
        topic.save()

        then:
        Topic.countByTopicTitleAndCreatedBy(topicTitle, user) == 1

        when:
        Topic duplicateTopic = new Topic(topicTitle: topicTitle, description: "groovy lang", createdBy: user, visibility: Visibility.PRIVATE)
        duplicateTopic.save()

        then:
        Topic.countByTopicTitleAndCreatedBy(topicTitle, user) == 1
        duplicateTopic.errors.allErrors.size() == 1
        duplicateTopic.errors.getFieldErrorCount('topicTitle') == 1
    }
}
