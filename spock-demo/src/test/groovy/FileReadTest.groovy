import spock.lang.Specification
import spock.lang.Unroll

class FileReadTest extends Specification{
    def sample
        void setup() {
        sample = new FileRead()
    }
    void fileRead(){
        given:
        String fileAddress = "src/resources/file.txt";
        when:
        String fileContent = sample.fileRead(fileAddress)
        then:
        fileContent == "hello friends\n"
    }
    @Unroll
    def "null file path test"(){
        given:
        String fileAddress2 = ""
        when:
        sample.fileRead(fileAddress2)
        then:
        thrown(Exception)
    }
}
