import spock.lang.Specification

class StringReplaceTest extends Specification {

    String[] getStr
    def "replace substring with string"() {
        expect:
        new StringReplace().getReplacedString(getStr) == expectedOutput;
        where:
        getStr                      | expectedOutput
        ["jitender", "j", "J"]      | "Jitender"
        ["hello",'e',"o"]           | "hollo"
        [" "," ", " " ]             | " "
    }
}
