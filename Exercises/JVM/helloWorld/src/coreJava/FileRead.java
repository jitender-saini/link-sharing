package coreJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Q9 Write a program to read text file & print the content of file using String Builder.

public class FileRead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            System.out.println(sb.toString());
        } finally {
            br.close();
        }
    }
}
