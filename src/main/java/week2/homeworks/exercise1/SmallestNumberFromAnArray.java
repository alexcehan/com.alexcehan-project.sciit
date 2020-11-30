package week2.homeworks.exercise1;

/*
2. Display the smallest number from an array of numbers (2 versions: with normal for and with foreach)
 */

import java.util.Scanner;

public class SmallestNumberFromAnArray {

    public static void main(String[] args) throws Exception {

        //run the code and create the array using Scanner.
        theSmallestNumberInArray();
    }

    public static void theSmallestNumberInArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many integers do you want to add to this array? ");
        int lengtOfArray = scanner.nextInt();

        int[] array = new int[lengtOfArray];

        for(int i = 0; i<array.length; i++) {
            if(i == array.length - 1) {
                System.out.println("Enter the last integer for this array: ");
            } else {
                System.out.println("Enter number: ");
            }
            array[i] = scanner.nextInt();
        }

        System.out.println("The smallest number in the array using the FOR LOOP is: " + forLoop(array));
        System.out.println("The smallest number in the array using the FOREACH LOOP is: " + foreachLopp(array));
    }

    public static int forLoop(int[] array) {
        /*
        Display the smallest numeber from an array using a for loop
         */
        int smallestNumber = array[0];

        for(int i = 0; i < array.length; i++) {
            if (array[i] < smallestNumber) {
                smallestNumber = array[i];
            }
        }
        return smallestNumber;
    }

     public static int foreachLopp(int[] array) {
         /*
        Display the smallest numeber from an array using a foreach loop
         */
        int smallestNumber = array[0];
        for (int i:array) {
            if (i < smallestNumber) {
                smallestNumber = i;
            }
        }
        return  smallestNumber;
    }
}
