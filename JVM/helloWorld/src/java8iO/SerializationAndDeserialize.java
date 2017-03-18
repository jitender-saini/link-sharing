package java8iO;

import java.io.*;

public class SerializationAndDeserialize {


    public static void main(String[] args) throws IOException,ClassNotFoundException {
        File dest = new File("destination.txt");
        Employee e1 = new Employee("Jay",22,1001,89000);
        serialize(e1,dest);
        System.out.println(deserialize(dest));

    }

    public static void serialize(Object obj, File fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }

    public static Object deserialize(File fileName) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee obj = (Employee)ois.readObject();
        ois.close();
        return obj;
    }

}
