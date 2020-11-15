package week1.homeworks;

import java.util.Arrays;

/*
9. Write a Java program to remove the duplicate elements of a given array and return the new length of the array.

     Sample array: [20, 20, 30, 40, 50, 50, 50]

     After removing the duplicate elements the program should return [20, 30, 40, 50] as the array without duplicates.

     Dupa un mic research pe google intelesesem ca ar fi metode mult mai simple de a obtine rezultatul de aici dar era vorba despre metode care imi sunt inca straine.
     Asa ca m-am folosit strict de cunostiintele pe care le aveam deja.
 */

public class RemoveVDuplicatesFromArray {
    public static void main(String[] args) {
        int[] array = {21, 1, 2, 3, 5, 5, 6, 7, 8, 9, 10, 11, 3, 12, 5, 0, 24, 8, 25, 1, 2, 39, 1, 1, 50, 2, 2, 27, 123, 5, 0, 0, 0, 0, 5, 5, 5};

        int[] finalArray = removeDuplicate(array);
        System.out.println(Arrays.toString(finalArray));






    }

    public static int[] removeDuplicate(int[] array) {

       // determine the length of the array after the duplicates are removed.

        int newArrayLength = array.length;
        for (int i=0; i < array.length; i++) {
            int j = i + 1;
            while(j < array.length) {
                if (array[i] == array[j]) {
                    newArrayLength--;

                    break;
                } else {
                    j++;
                }


            }

        }


        // copy the values from the initial array to the new one without the duplicates

        int[] finalArray = new int[newArrayLength];
        finalArray[0] = array[0];
        int availablePosition = 1;

        int i = 1;
        int j = 0;

        boolean flag = true;
        while (flag) {

            while (j < availablePosition) {
                if (array[i] == finalArray[j]) {
                    i++;
                    j=0;
                    break;
                } else {
                    j++;
                }
                if (j == availablePosition) {
                    finalArray[availablePosition] = array[i];
                    availablePosition++;
                    j=0;
                }
            }

            if (i == array.length) {
                flag = false;
            }

        }

        return finalArray;


    }
}


