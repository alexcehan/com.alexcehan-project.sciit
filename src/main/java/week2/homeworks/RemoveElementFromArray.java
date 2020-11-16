package week2.homeworks;

import java.util.Arrays;
import java.util.Scanner;

/*
10. Write a Java program to remove a specific element from an array.
 */

public class RemoveElementFromArray {

    public static void main(String[] args) {
        int[] array = {21, 1, 2, 3, 5, 5, 6, 7, 8, 9, 10, 11, 3, 12, 5, 0, 24, 8, 25, 1, 2, 39, 1, 1, 50, 2, 2, 27, 123, 5, 0, 0, 0, 0, 5, 5, 5};

        Scanner scanner = new Scanner(System.in);

        System.out.println("What number you want to remove from the array? ");

        boolean flag = true;
        int number = 0;

        while (flag) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                flag = false;
            } else {
                scanner.nextLine();
                System.out.println("Please enter a valid value!");
            }
        }

        int[] finalArray = removeElement(number, array);

        System.out.println("Initial array was: " + Arrays.toString(array));
        System.out.println("The array after the element was removed: " + Arrays.toString(finalArray));


    }

    public static int[] removeElement(int element, int[] array) {
        // determine the length of the array after the duplicates are removed.

        int newArrayLength = array.length;
        for (int k : array) {
            if (k == element) {
                newArrayLength--;
            }

        }

        //specify how many times the element was found in the array

        if(newArrayLength == array.length) {
            System.out.println("The entered number wasn't found in the array");
        } else {
            System.out.println("The entered number was found in the array " + (array.length - newArrayLength) + " times");
        }


        //create the new array without the entered element

        int[] finalArray = new int[newArrayLength];

        for (int i = 0, j=0; j< finalArray.length; i++) {
            if(array[i] != element) {
                finalArray[j] = array[i];
                j++;
            }
        }

        return (finalArray);

    }
}
