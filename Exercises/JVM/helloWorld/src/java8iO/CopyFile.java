package java8iO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File dest = new File("destination.txt");
        //fileCopyUsingApacheCommonsIO(source, dest);
        fileCopyUsingInputStream(source, dest);
        //fileCopyUsingJava7Files(source, dest);
    }
    private static void fileCopyUsingApacheCommonsIO(File source, File dest)
        throws IOException {
        FileUtils.copyFile(source, dest);
        System.out.println("File copied successfully!!");
    }
    private static void fileCopyUsingInputStream(File source, File dest) throws IOException{
        FileInputStream ins = new FileInputStream(source);
        FileOutputStream outs = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = ins.read(buffer)) > 0) {
                outs.write(buffer, 0, length);
            }
            ins.close();
            outs.close();
            System.out.println("File copied successfully!!");
    }
    private static void fileCopyUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
        System.out.println("File copied successfully!!");
    }
    }