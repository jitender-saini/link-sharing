import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListExample {
    public static void main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        list.add("Jay");
        list.add("Sam");
        list.add("Ram");
        list.add("Tim");
        list.add("Kim");
        list.add("shi");
        ListIterator litr = list.listIterator();
        System.out.println("Elements in forward list");
        while(litr.hasNext()){
            System.out.println(litr.next());
            if(litr.nextIndex()==2)
                litr.set("hello");
            if(litr.nextIndex()==3)
                litr.set("World");
        }

        System.out.println("Elements in Backward list");
        while(litr.hasPrevious()){
            System.out.println(litr.previous());
        }
        System.out.println("after changes");
        while(litr.hasNext()) {
            System.out.println(litr.next());
        }

    }

}
