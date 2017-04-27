package com.ttn.linkSharing

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

    @Unroll("#sno")
    void "validateDocumentResource"() {

        setup:
        DocumentResource documentResource = new DocumentResource(filePath: filePath, description: description)

        when:
        Boolean result = documentResource.validate(['description', 'filePath'])

        then:
        result == valid

        where:
        sno | description   | filePath      | valid
        1   | "description" | '/ home/test' | true
        2   | " "           | '/home/test'  | false
        3   | null          | '/home/test'  | false
        4   | "description" | ' '           | false
        5   | "description" | null          | false
    }
}