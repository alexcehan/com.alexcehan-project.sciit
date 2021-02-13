package week12.homework.smallApplication;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)  {

        String srcFile = "src/main/java/week12/practice/DatabaseFile.csv";
        String destFile = "src/main/java/week12/homework/smallApplication/output.csv";
        int month = 8;

        filterDatabase(srcFile, month, destFile);



    }

    public static void filterDatabase(String srcFile, int numberOfMonth, String destFile) {

        String line;
        List<Human> humanList = new ArrayList<>();
        int month = numberOfMonth;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile))) {


            while((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                if (split[0].equals("FirstName")) {
                    continue;
                }
                try {
                    String[] split1 = split[2].split("-");
                    humanList.add(new Human(split[0], split[1], Integer.parseInt(split1[0]), Integer.parseInt(split1[1]), Integer.parseInt(split1[2])));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }



        Stream<Human> humans = humanList.stream();

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFile))) {

            bufferedWriter.write("First Name, LastName");
            bufferedWriter.newLine();

            humans.filter(human -> human.getMonth() == month)
                    .distinct()
                    .sorted(Comparator.comparing(Human::getFirstName))
                    .forEach(human -> {
                        try {
                            bufferedWriter.write(human.getFirstName()+","+human.getLastName());
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });



        } catch (java.io.IOException e) {
            System.out.println(e);
        }

    }
}
