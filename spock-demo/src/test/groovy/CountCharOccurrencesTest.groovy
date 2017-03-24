import spock.lang.Specification


class CountCharOccurrencesTest extends Specification  {

    def sample

    void setup(){
        sample = new CountCharOccurrences()
    }
void count(){
    given:
    String str = "hello"
    String chr = "l"
    when:
    int count = sample.countDuplicate(str,chr)
    then:
    count == 2
    }

}
