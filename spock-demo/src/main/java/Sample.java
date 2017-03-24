public class Sample {

    public String welcomePerson(String firstName, String lastName){
        return "Welcome "+firstName+" "+lastName+" to TTN";
    }

    public Integer division(Integer a, Integer b){
        if(b == 0){
            throw new RuntimeException();
        }
        else
            return (a/b);
    }
    public static void main(String[] args){

    }
}
