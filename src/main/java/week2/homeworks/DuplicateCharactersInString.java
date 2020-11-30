package week2.homeworks;

/*
3. Write a Java method to find the duplicate characters in a string. (Hint use str.toCharArray() to split the string into an array of characters)

Probabil m-am complicat si mi-am batut capul cu exercitiul asta mult mai mult decat avea sens. Nu am luat in considerare spatiile goale daca apareau in string
dar am lasat totusi programul Case Sensitive.
 */

public class DuplicateCharactersInString {

    public static void main(String[] args) {
        String someString = ("Alexx");


        if(checkIfDuplicates(someString)) {
            findDuplicates(someString);
        } else {
            System.out.println("No duplicates were found in this string");

        }

    }

    public static void findDuplicates(String someString) {


        char[] someStringArray = someString.toCharArray();
        char[] tempArray = uniqueElementsInArray(someString);




        for(int i=0, count=0; i<tempArray.length; i++) {
            for(char j: someStringArray) {
                if (tempArray[i] == j) {
                    count++;
                }
            }
            if(count>1) {
                printDuplicates(tempArray[i], someStringArray);
            }
            count=0;

        }

    }

    public static boolean checkIfDuplicates (String someString) {

        String tempString = someString.replace(" ", "");
        char[] stringArray = tempString.toCharArray();

        for(int i=0; i< stringArray.length-1;i++) {
            for (int j=i+1;j<stringArray.length;j++) {
                if (stringArray[i] == stringArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }



    public static void printDuplicates(char element, char[] array) {
        System.out.println("The element [" + element +"] was found multiple times in this string: ");
        for (int i=0; i< array.length; i++) {
            if(array[i] == element) {
                System.out.println("\t-on place [" + i +"].");
            }
        }

    }



    public static char[] uniqueElementsInArray(String someString) {
        String tempString = someString.replace(" ", "");


        char[] stringArray = tempString.toCharArray();
        char[] tempArray = new char[tempString.length()];



        for (int i=0, availablePosition=0; i< stringArray.length; i++) {
            boolean flag = true;
            for(int j:tempArray) {
                if (stringArray[i] == j) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                tempArray[availablePosition] = stringArray[i];
                availablePosition++;
            }
        }


        return tempArray;
    }

}
