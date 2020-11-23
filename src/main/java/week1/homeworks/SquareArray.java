package week1.homeworks;

public class SquareArray {

    public static void main(String[] args) {

        int array[][]={{5,3,6},{21,54,123},{12,876}};
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
