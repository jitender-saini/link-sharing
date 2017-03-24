import spock.lang.Specification
import spock.lang.Unroll

class SearchSingleElementTest extends Specification{

    @Unroll
    def "Finding one single element"(){
        expect:
        new SearchSingleElement().findSingle(input) == expectedResult
        where:
        input                                 | expectedResult
        [1,2,3,2,3]                           | 1
        [13,34,45,14,56,34,13,56,45]          | 14

    }

    @Unroll
    def "Finding all single elements in the list"(){
        expect:
        new SearchSingleElement().findSingleElements(input) == expectedResult
        where:
        input                                 | expectedResult
        [1,2,3,2,3,5,6,7]                     | [1,5,6,7]
        [13,34,44,77,45,14,33,56,34,13,56]    | [44,77,45,14,33]
    }

    @Unroll
    def "Finding one single element using XOR Operator"(){
        expect:
        new SearchSingleElement().findSingleElement(input) == expectedResult
        where:
        input                                 | expectedResult
        [1,2,3,2,3]                           | 1
        [13,34,45,14,56,34,13,56,45]          | 14

    }
}
