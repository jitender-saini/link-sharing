import spock.lang.Specification
import spock.lang.Unroll

class ReverseRemoveStringTest extends Specification {

    @Unroll("reverseRemove() test #sno")
    def "reverse a string and remove  character from index 4 to index 9"(){
        setup:
        ReverseRemove reverseRemove = new ReverseRemove()
        String output

        when:
        output = reverseRemove.reverseString(input)

        then:
        output == expectedOutput

        where:
        sno | input                     | expectedOutput
        1   | "hello world"             | "dlroeh"
        2   | " "                       | " "
        3   | "9876543210"              | "01239"
    }
}
