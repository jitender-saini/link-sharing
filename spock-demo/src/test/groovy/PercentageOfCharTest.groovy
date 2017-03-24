import spock.lang.Specification
import spock.lang.Unroll

class PercentageOfCharTest extends Specification {

    @Unroll
    def "Test the percentage of every type of input in the string"(){
        expect:
        new PercentageOfCharacters().characterPercentage(input) == expectedOutput
        where:
        input                                           | expectedOutput
        "frhds323jio2JDOI(*)(*)(<>?.+-*555,jhdsiu67"    | ["Uppercase":9.5,"Lowercase":33.3,"Digits":21.4, "Other":35.7]
        "ds,fjjkh32678976IhefuiUIUIHHE54321^%^&^&78"    | ["Uppercase":19.0,"Lowercase":28.6,"Digits":35.7, "Other":16.7]
        "JHGJHKSGJHDGHJGYD"                             | ["Uppercase":100,"Lowercase":0.0,"Digits":0.0, "Other":0.0]
        "6431618435186435418646536"                     | ["Uppercase":0.0,"Lowercase":0.0,"Digits":100.0, "Other":0.0]
        "akjdjksdfksdfjkwefukjsdnfksnfkjsldd"           | ["Uppercase":0.0,"Lowercase":100,"Digits":0.0, "Other":0.0]
        "&*^&(&*(&^&(&^%((^&(&*-+-*//*--+"              | ["Uppercase":0.0,"Lowercase":0.0,"Digits":0.0, "Other":100.0]
        "aADdGghHjJkKlLuUiIoO"                          | ["Uppercase":50.0,"Lowercase":50.0,"Digits":0.0, "Other":0.0]
    }

    @Unroll
    def "Test the percentage of every type of input in the string using ASCII codes"(){
        expect:
        new PercentageOfCharacters().getPercentage(input) == expectedOutput
        where:
        input                                           | expectedOutput
        "frhds323jio2JDOI(*)(*)(<>?.+-*555,jhdsiu67"    | ["Uppercase":9.5,"Lowercase":33.3,"Digits":21.4, "Other":35.7]
        "ds,fjjkh32678976IhefuiUIUIHHE54321^%^&^&78"    | ["Uppercase":19.0,"Lowercase":28.6,"Digits":35.7, "Other":16.7]
        "JHGJHKSGJHDGHJGYD"                             | ["Uppercase":100,"Lowercase":0.0,"Digits":0.0, "Other":0.0]
        "6431618435186435418646536"                     | ["Uppercase":0.0,"Lowercase":0.0,"Digits":100.0, "Other":0.0]
        "akjdjksdfksdfjkwefukjsdnfksnfkjsldd"           | ["Uppercase":0.0,"Lowercase":100,"Digits":0.0, "Other":0.0]
        "&*^&(&*(&^&(&^%((^&(&*-+-*//*--+"              | ["Uppercase":0.0,"Lowercase":0.0,"Digits":0.0, "Other":100.0]
        "aADdGghHjJkKlLuUiIoO"                          | ["Uppercase":50.0,"Lowercase":50.0,"Digits":0.0, "Other":0.0]
    }
}