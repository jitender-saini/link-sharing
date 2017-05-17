package coreJava;

// Q10 Write a program to display values of enums using a constructor & getPrice() method(Example display house & thier prices ).

public class EnumExercise {
    enum Flat {
        ONE_BHK(10000),
        TWO_BHK(15000),
        THREE_BHK(20000),
        FOUR_BHK(30000);
        private int price;

        Flat(int p) {
            price = p;
        }
        int getPrice() {
            return price;
        }
    }

    void display(){
        System.out.println("Rent Details of Flat : ");
        for (Flat flat : Flat.values())
            System.out.println(flat + " costs " + flat.getPrice() + " rupees");
    }

        public static void main(String args[]){
            EnumExercise flats = new EnumExercise();
            flats.display();
        }
}

