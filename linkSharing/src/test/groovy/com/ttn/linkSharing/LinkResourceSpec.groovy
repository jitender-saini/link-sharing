package com.ttn.linkSharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    @Unroll("#sno")
    void "validateDocumentResource"() {

        setup:
        LinkResource documentResource = new LinkResource(url: url, description: description)

        when:
        Boolean result = documentResource.validate(['description', 'url'])

        then:
        result == valid

        where:
        sno | description   | url                        | valid
        1   | "description" | 'http://www.tothenew.com/' | true
        2   | " "           | 'http://www.tothenew.com/' | false
        3   | null          | 'http://www.tothenew.com/' | false
        4   | "description" | ' '                        | false
        5   | "description" | null                       | false
    }
}