package coreJava;

// Q8 Write a program to reverse a string and remove character from index 4 to index 9 from the reversed string using String Buffer.
public class ReverseRemove {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("This string is reversed and then removed 4-9 indexes");
        StringBuffer reverse = new StringBuffer(str).reverse();
        System.out.println("Original String : " + str + "\nReversed String : " + reverse);
        reverse.delete(4, 9);
        System.out.println("Reversed String with removed indexes : " + reverse);
    }
}
