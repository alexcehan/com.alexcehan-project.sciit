package week1.homeworks;

/*
10. Write a method that checks if the array is square (i.e. every row has the same length as a itself).
*/

public class SquareArray {

    public static void main(String[] args) {

        int array[][]={{5,3,6},{21,54,123},{12,876, 23}, {2, 12, 32}};
        System.out.println(checkIfSquareArray(array));

    }

    public static boolean checkIfSquareArray(int[][] masterArray) {
        for(int[] array:masterArray) {
            if(array.length != masterArray.length) {
                return false;
            }
        }

        return true;


    }
}
