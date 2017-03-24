import spock.lang.Specification
import spock.lang.Unroll

class PrintDuplicateWordsTest extends Specification {

    @Unroll("Testing findDuplicate(): #sno")
    def "Testing find duplicate character in the given string"() {
        setup:
        PrintDuplicateWords printDuplicateWords = new PrintDuplicateWords()
        Map output

        when:
        output = printDuplicateWords.findDuplicate(input)  //.toString()

        println output
        println expectedOutput

        then:
        output == expectedOutput

        where:
        sno | input       | expectedOutput
        1   | "akdaskjks" | [("a".charAt(0)): 2, ("k".charAt(0)): 3] //as Map
    }
}
