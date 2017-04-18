import groovy.transform.ToString

@ToString
class Person {
    String name
    int age
    String gender
    String address

    static void main(String[] args) {
        Person person = new Person()

        person.setName("Jay")
        person.setAge(24)
        person.setGender("male")
        person.setAddress("Noida")

        println("Name :"+person.getName())
        println("Age :"+person.getAge())
        println("Gender :"+person.getGender())
        println("Address :"+person.getAddress())

        println(person.name)
        println(person)
    }
}
