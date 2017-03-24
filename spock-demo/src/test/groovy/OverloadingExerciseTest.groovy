import spock.lang.Specification
import spock.lang.Unroll


class OverloadingExerciseTest extends Specification{
    @Unroll
    def "Overloading test"(){
        expect:
        new OverloadingExercise().operation(a,b) == expectedOutput
        where:
        a     | b       | expectedOutput
        2     | 2       | 4
        2.3   | 4.6     | 6.9
        "Hello "  | "friends"   | "Hello friends"
        12f   | 15F     |  27f
    }
}
