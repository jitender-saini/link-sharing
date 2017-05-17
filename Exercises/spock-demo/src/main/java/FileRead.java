import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) throws IOException{
            System.out.println(fileRead("src/resources/file.txt"));

    }
    public static String fileRead(String fileAddress)throws RuntimeException, IOException{

         StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(fileAddress));
       // try {
            String line = br.readLine();
            while (line != null) {
                sb.append(line+"\n");
                //sb.append("\n");
                line = br.readLine();
            }
       // } finally {
          //  br.close();
      //  }
        return sb.toString();
    }
}