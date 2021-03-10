package week6.homeworks;

import java.util.ArrayList;
import java.util.Collections;

public class MainClassToTest {
    public static void main(String[] args) {
        String givenString = "alexandru";
        String givenString2 = "exandrual ";
//        System.out.println(reverseString(givenString));
//        System.out.println(checkIfPalindrome(givenString));
//        countVowelsAndConsonants(givenString);
//        System.out.println(countOccurenceOfChar('e', givenString));
//        System.out.println(checkIfAllCharsAreDigits(givenString));
//        System.out.println(convertStringToInt(givenString));
//        System.out.println(removeCharacterFromString('a', "alexandru"));
//        firstNonRepeatedCharacter(givenString);
//        System.out.println(removeDuplicatesFromString(givenString));
        //findDuplicatesFromString(givenString);
       // areAnagrams(givenString, givenString2);
       // System.out.println(reverseWordsInString(givenString));
        System.out.println(checkIfRotation(givenString, givenString2));


    }

        //Write a method to reverse a given string.
    public static String reverseString (String givenString) {
        String returnedString = "";
        char[] stringArray = givenString.toCharArray();

        for (int i = stringArray.length-1; i >= 0 ; i--) {
            returnedString += stringArray[i];
        }

        return returnedString;
    }

    public static void printDuplicates(String givenString) {
//        char[] stringArray = givenString.toCharArray();
//
//        for (int i = 0; i < stringArray.length - 1; i++) {
//            for (int j = i+1; j < stringArray.length; j++) {
//                if (stringArray[i] == stringArray[j]) {
//                    System.out.println();
//                }
//
//            }
//        }

    }
        //Write a method to check if a given string is a palindrome.
    public static boolean checkIfPalindrome(String givenString) {
        char[] charArray = givenString.toCharArray();
        String testString = "";

        for (int i = charArray.length-1; i >= 0 ; i--) {
            testString += charArray[i];
        }

        if(givenString.equals(testString)) {
            return true;
        } else {
            return false;
        }

    }
        //Write a method to count a number of vowels and consonants in a given string.
    public static void countVowelsAndConsonants (String givenString) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char[] consonants ={'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        int vowelsCount = 0;
        int consonantsCount = 0;

        char[] stringArray = givenString.toCharArray();

        for (char element : stringArray) {
            for (int i = 0; i < vowels.length; i++) {
                if (Character.toLowerCase(element) == vowels[i]) {
                    vowelsCount++;
                    break;
                }
            }

            for (int i = 0; i < consonants.length; i++) {
                if (Character.toLowerCase(element) == consonants[i]) {
                    consonantsCount++;
                    break;
                }
            }
        }
        System.out.println("In the given array are: " + vowelsCount + " vowels and " + consonantsCount + " consonants!");
    }


    public static int countOccurenceOfChar(char charToCheck, String givenString) {
        int charCount = 0;
        char[] stringArray = givenString.toCharArray();

        for(char element: stringArray) {
            if (Character.toLowerCase(element) == Character.toLowerCase(charToCheck)) {
                charCount++;
            }
        }
        return charCount;
    }

        //Write a method to check if a string contains only digits.
    public static boolean checkIfAllCharsAreDigits(String givenString) {
        char[] stringArray = givenString.toCharArray();

        for(char character : stringArray) {
            if(Character.isDigit(character)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

        //Write a method to convert a given String into int like the Integer.parseInt().
    public static int convertStringToInt(String givenString) {
        int convertedString = 0;
        if(!checkIfAllCharsAreDigits(givenString)) {
            System.out.println("The given string cannot be converted to int.");
            return -1;
        } else {
            char[] stringArray = givenString.toCharArray();
            for (int i = 0; i < stringArray.length; i++) {
                convertedString = convertedString * 10 + ((int)stringArray[i] - 48);
            }
            return convertedString;
        }
    }

            //Write a method to remove a given character from String.
    public static String removeCharacterFromString(char character, String givenString) {
        StringBuilder sb = new StringBuilder(givenString);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == character ) {
                sb.deleteCharAt(i);
            }

        }
        givenString = sb.toString();

        return givenString;
    }

    public static void firstNonRepeatedCharacter(String givenString) {
        StringBuilder sb = new StringBuilder(givenString);
        boolean flag = false;

        for (int i = 0; i < sb.length(); i++) {

            if (flag) {
                break;
            }
            for (int j = 0; j < sb.length(); j++) {
                if ((j == i) && (j != sb.length() - 1)) {
                    continue;
                }
                if ((sb.charAt(i) == sb.charAt(j))) {
                    if (i != j) {
                        break;
                    } else if (j != sb.length() - 1) {
                        break;
                    }

                }

                if (j == sb.length() - 1) {
                    System.out.println(sb.charAt(i));
                    flag = true;
                }

            }
        }
    }
            //Write a method to remove the duplicate character from String.
    public static String removeDuplicatesFromString(String givenString) {

        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char ch : givenString.toCharArray()) {
            characterArrayList.add(ch);
        }
        ArrayList<Character> tempCharList = new ArrayList<Character>(1);
        tempCharList.add(characterArrayList.get(0));
        StringBuilder sb = new StringBuilder();
        String tempString = "";


        for (int i = 0; i < characterArrayList.size(); i++) {
            for (int j = 0; j < tempCharList.size(); j++) {
                if ((characterArrayList.get(i) == tempCharList.get(j))) {
                    break;
                }

                if (j == tempCharList.size()-1) {
                    tempCharList.add(characterArrayList.get(i));
                }
            }
        }

        for (Character ch: tempCharList) {
            sb.append(ch);
        }

        return (sb.toString());
    }

            //Write a method to find duplicate characters in a given string.
    public static void findDuplicatesFromString(String givenString) {

    }
            //Write a method to check if two strings are anagrams of each other.
    public static void areAnagrams (String givenString1, String givenString2) {

        if (givenString1.length() != givenString2.length()) {
            System.out.println("The given strings aren't anagrams to each other!");
            return;
        }
        ArrayList<Character> str1List = new ArrayList<>();
        ArrayList<Character> str2List = new ArrayList<>();

        for(Character ch : givenString1.toCharArray()) {
            str1List.add(ch);
        }

        for(Character ch : givenString2.toCharArray()) {
            str2List.add(ch);
        }

        Collections.sort(str1List);
        Collections.sort(str2List);

        for (int i = 0; i < str1List.size(); i++) {
            if (str1List.get(i) != str2List.get(i)) {
                System.out.println("The given strings aren't anagrams to each other!");
                break;
            } else {
                if (i == str1List.size() -1) {
                    System.out.println("The given strings are anagrams to each other!");
                }
            }
        }
    }

               //Write a method to reverse words in a given sentence without using any library method.
    public static String reverseWordsInString(String givenString) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for(String word: givenString.split(" ")) {
            stringArrayList.add(word);
        }

        ArrayList<String> tempStringList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String word: stringArrayList) {
            for (char ch: word.toCharArray()) {
                sb.insert(0, ch);
            }
            tempStringList.add(sb.toString());
            sb.delete(0, sb.length());
        }

        for(String word: tempStringList) {
            sb.append(word + " ");
        }
        return sb.toString();
    }

            //Write a method to check if two strings are a rotation of each other.
    public static boolean checkIfRotation(String givenString1, String givenString2) {
        givenString1 = givenString1.toLowerCase();
        givenString2 = givenString2.toLowerCase();
        StringBuilder sb = new StringBuilder(givenString2);
        char ch = '0';
        if (givenString1.length() != givenString2.length()) {
            return false;
        } else {
            for (int i = 0; i < givenString1.length(); i++) {
                ch = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(ch);

                if (givenString1.equals(sb.toString())) {
                    return true;
                }
            }
        }

        return false;

    }


}
