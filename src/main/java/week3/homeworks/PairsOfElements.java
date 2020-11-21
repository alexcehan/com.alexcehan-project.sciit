package week3.homeworks;
/*
Write a Java method to find all pairs of elements in an array whose sum is equal to a given number
 */

public class PairsOfElements {

    public static void main(String[] args) {
        int[] array = {2, 6, 7, 4, 3, 7, 4, 2, 8,2, 12};
        int number = 12;

        pairsInArray(array, number);



    }

    public static void pairsInArray(int[] array, int number) {
        boolean flag = true;
        for(int i=0; i< array.length; i++) {
            for (int j=i; j< array.length;j++) {
                if (array[i]+ array[j] == number) {
                    if (i !=j) {
                        System.out.println("Array["+ i +"] and Array [" + j + "] are a pair.");
                        flag = false;
                    }
                }
            }
        }

        if(flag) {
            System.out.println("No pair was found in the array!");
        }

    }
}
