package week12.practice;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        String srcFile = "C:\\Users\\Bui\\Downloads\\dataJan-31-2021 (10).csv";
        String destFile = "src/main/java/week12/practice/DatabaseFile.csv";

        copyDataFromCsv(srcFile, destFile);
    }

    public static void copyDataFromCsv(String srcFile, String destFile) {
        String line;
        int count = 0;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("FirstName")) {
                    continue;
                }


                String[] split = line.split("\\|");


                if (!checkForDuplicates(split, destFile)) {
                   try ( BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destFile, true))) {
                       bufferedWriter.write(split[0]+","+split[1]+","+split[2]);
                       bufferedWriter.newLine();

                    }catch (IOException e) {
                       System.out.println(e + "at writing file!");
                   }

                } else {
                    count++;
                }
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("Were found " + count + " duplicates!");


    }

    public static boolean checkForDuplicates(String[] split, String destFile) {
        try(BufferedReader bufferedReader1 = new BufferedReader(new FileReader(destFile))) {
            String line1;
            while ((line1 = bufferedReader1.readLine()) != null) {
                if (line1.startsWith("FirstName")) {
                    continue;
                }
                String[] split1 = line1.split(",");
                if ((split[0].equals(split1[0])) && (split[1].equals(split1[1]))) {
                    return true;
                }

            }

        } catch (IOException e) {
            System.out.println(e + " in writing file.");
        }
        return false;
    }
}
