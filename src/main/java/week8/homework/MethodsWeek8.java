package week8.homework;

import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


@Log4j2
public class MethodsWeek8 {

    public static void main(String[] args) throws Exception {
        String givinDir = "src/main/java";
        String givinFile = "src/main/java/week8/homework/biathlon/race_results.csv";
      /* 1. */  listDirectoryContent(givinDir);
      /* 3. */  System.out.println(checkIfFileOrDirectoryExist(givinFile));
      /* 4. */ checkReadWritePermission(givinFile);
      /* 5. */  checkIfFileOrDirectory(givinDir);
      /* 6. */  System.out.println(lastModifiedTime(givinFile));
      /* 7. */  getFileSize(givinFile);
      /* 9. */ storeFileToArray(givinFile);
      /* 12.*/ printFirstThreeLine(givinFile);
      /* 13 */ System.out.println(returnLongestWordInFile(givinFile));
      /* 14 */ System.out.println(checkIfWordExistsInFile(givinFile, "Athlete"));


    }


    public static void listDirectoryContent(String path)  { //1. Implement a method to get a list of all file/directory names from the given.
        //System.out.println(path);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path path1 : stream) {
                if (!Files.isDirectory(path1)) {
                    System.out.println("  --" + path1.getFileName().toString());
                } else {
                    System.out.println("--" + path1);
                    listDirectoryContent(path1.toString());
                }
            }


        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static boolean checkIfFileOrDirectoryExist (String path) { // 3. Implement a method to check if a file or directory specified by pathname exists or not.
        Path path1 = Paths.get(path);

        if (Files.isDirectory(path1) || Files.isRegularFile(path1)) {
            return true;
        } else {
            return false;
        }
    }

    public static void checkReadWritePermission (String path) { //4. Implement a method to check if a file or directory has read and write permission.
        Path path1 = Paths.get(path);
        File file = new File(path);

        if(file.isFile()) {
            if (file.canRead()) {
                System.out.println("File has Read Access");
            } else {
                System.out.println("File doesn't have Read Access");
            }

            if (file.canWrite()) {
                System.out.println("File has Write Access.");
            } else {
                System.out.println("File doesn't have Write Access.");
            }
        } else if (file.isDirectory()) {
            if (file.canRead()) {
                System.out.println("Directory has Read Access");
            } else {
                System.out.println("Directory doesn't have Read Access");
            }

            if (file.canWrite()) {
                System.out.println("Directory has Write Access.");
            } else {
                System.out.println("Directory doesn't have Write Access.");
            }
        } else {
            System.out.println("The path isn't valid!");
        }



    }

    public static void checkIfFileOrDirectory(String path) { //5. Implement a method to check if given pathname is a directory or a file.
        Path path1 = Paths.get(path);

        if(Files.isRegularFile(path1)) {
            System.out.println("The given pathname is a file!");
        } else if (Files.isDirectory(path1)) {
            System.out.println("The given pathname is a directory!");
        } else {
            System.out.println("This is not a valid path!");
        }
    }

    public static String lastModifiedTime(String path) { //6. Implement a method to get last modified time of a file.
        Path path1 = Paths.get(path);
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        if (Files.isRegularFile(path1)) {
            try {
                return (df.format(Files.getLastModifiedTime(path1).toMillis()));

            } catch (IOException e) {
                return e.toString();
            }

        } else {
            return ("This is not a file!");
        }

    }

    public static void getFileSize(String path) { //7. Implement a method to get file size in bytes, kb, mb.

        Path path1 = Paths.get(path);
        if (Files.isRegularFile(path1)) {
            float size = 0.0f;
            try {
                size = Files.size(path1);
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("Size in bytes is " + size);
            System.out.println("Size in kb is " + (size/1000));
            System.out.println("Size in mb is " + ((size/1000)/1024));

        } else {
            System.out.println("This is not a file!");
        }

    }

    public static String[] storeFileToArray(String path) { //9. Implement a method to store text file content line by line into an array.
        ArrayList<String> stringList = new ArrayList<String>();
        String line;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }





        String[] array = new String[stringList.size()];
        array = stringList.toArray(array);

        return array;
    }



    public static void printFirstThreeLine (String filename) {  //12. Implement a method to read first 3 lines from a file.
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            int count = 0;
            String line;

            while (((line = bufferedReader.readLine())!= null) && count < 3) {
                System.out.println(line);
                count++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }



    public static String returnLongestWordInFile(String filename) { //13. Implement a method to find the longest word in a text file.
        String longestWord = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",|\\.|\\ |\\:|\\(|\\)");
                for (String word : split) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        return longestWord;
    }

    public static boolean checkIfWordExistsInFile(String filename, String givenWord) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",|\\.|\\ |\\:|\\(|\\)");
                for (String word: split) {
                    if (word.equals(givenWord)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }


        return false;
    }


}
