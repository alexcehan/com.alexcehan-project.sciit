package week4.practice;

import java.util.Random;

public class RandomCLass {

    public static void main(String[] args) {
        System.out.println(generateIban());




    }

    public static String generateIban() {
        Random rn = new Random();
        int range = 99999999 - 10000000 + 1;
        int number = rn.nextInt(range) + 10000000;
        String tempIban = ("BANK2020RO" + number);


        return tempIban;
    }

}
