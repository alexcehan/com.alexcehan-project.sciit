package week8.practice;

import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

@Log4j2
public class IoPractice {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/week8/homework/biathlon/race_results.csv");
        String filepath = ("src/main/java/week8/homework/biathlon/race_results.csv");

        System.out.println(Files.size(path));
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(df.format(Files.getLastModifiedTime(path).toMillis()));
        //System.out.println(Files.getPosixFilePermissions(path));
        File file = new File(filepath);

        System.out.println(file.canExecute());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
    }
}
