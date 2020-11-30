package week1.extra_homeworks;

import java.util.Scanner;
/*
7. Write a Java program to calculate the average value of array elements.


 */

public class CheckIfValueInArray {
    public static void main(String[] args) {

        //Deoarece si enuntul problemei era destul de vag, am creat in main() un array random fara sa il mai fac din imputul userului
        int[] array = {12, 32, 54, 65, 76, 465, 3245, 2324, 1244, 43, 341, 143, 17, 5, 198};

        Scanner scanner = new Scanner(System.in);
        int number = 0;

        System.out.println("Enter the value you want to check if is in the array: ");

        boolean flag = true;

        while (flag) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                flag = false;
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }
        }

        if(checkValue(number, array)) {
            System.out.println("The array contains the entered value!");
        } else {
            System.out.println("The entered value wasn't found in the array!");
        }



    }

    public static boolean checkValue (int number, int[] array) {
        for (int j : array) {
            if (number == j) {
                return true;
            }
        }
        return false;
    }
}
