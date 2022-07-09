package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class Easy_2259_RemoveDigitFromNumberToMaximizeResult {
    public static void main(String[] args) {

        String number = "123";
        char digit = '3';
        String answer = removeDigit(number, digit);
        System.out.println(answer);
    }

    private static String removeDigit(String number, char digit) {


        //2132
        //idea
        //we want to remove the first character that matches the digit
        //and the next character in the number is > the digit
        //this will give us the largest number

        int indexToRemove = -1;

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                indexToRemove = i;

                //don't forget to stay in bounds
                //we can compare the 'size' of the characters
                if (i + 1 < number.length() && number.charAt(i + 1) > digit) {
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder(number);
        sb.deleteCharAt(indexToRemove);
        return sb.toString();
    }
}
