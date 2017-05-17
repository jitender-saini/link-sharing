import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class SampleSpec extends Specification  {

    def sample

    void setup(){
        sample = new Sample()
    }

    void welcomePerson() {
        given:
        String firstName = "Test"
        String lastName = "User"
        when:
        String greeting = sample.welcomePerson(firstName, lastName);

        then:
        greeting == "Welcome Test User to TTN"
    }

    @Ignore
    void welcomePersonFailure() {
        given:
        String firstName = "Test"
        String lastName = "User"
        when:
        String greeting = sample.welcomePerson(firstName, lastName);

        then:
        greeting == "Welcome"
    }

    void welcomePersonTestUsingWhere(){
        expect:
        sample.welcomePerson(fName, lName) == expectedResult

        where:
        fName   | lName   | expectedResult
        "Test1" | "User1" | "Welcome Test1 User1 to TTN"
        "Test2" | "User2" | "Welcome Test2 User2 to TTN"
    }

    void divisionHappyCase() {
        given:
        Integer a = 50
        Integer b = 10
        when:
        Integer result = sample.division(a, b)

        then:
        result == 5
    }

    void divisionSadCase() {
        given:
        Integer a = 50
        Integer b = 0
        when:
        sample.division(a, b)

        then:
        thrown(RuntimeException)
    }


    @Unroll
    void welcomePersonTestUsingWHereAndUnroll(){
        expect:
        sample.welcomePerson(fName, lName) == expectedResult

        where:
        fName   | lName   | expectedResult
        "Test1" | "User1" | "Welcome Test1 User1 to TTN"
        "Test2" | "User2" | "Welcome Test2 User2 to TTN"
    }


}
