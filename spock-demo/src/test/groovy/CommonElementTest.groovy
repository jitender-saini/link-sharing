import spock.lang.Specification
import spock.lang.Unroll

class CommonElementTest extends Specification{
    def sample
    void setup(){
        sample = new CommonElements()
    }
    @Unroll
    void countCommon(){
        given:
        int[] ar1 = [1,2,3,4,6,7,2]
        int[] ar2 = [1,2,3,4,6,7]
        when:
        ArrayList list = sample.countCommon(ar1,ar2)
        then:
        list == [1,2,3,4,6,7,2]
        list.size() == 7
    }
    @Unroll
    def "Null elements"(){
        given:
        int[] ar1 = []
        int[] ar2 = []
        when:
        ArrayList list =sample.countCommon(ar1,ar2);
        then:
        list == []
        //thrown(Exception)
    }

}
