package Chewy;

import java.util.HashMap;

public class ShiftingLetters {
    public static void main (String[] args) {

//        String s = "abcd";
//        int[] shifts = {1,2,3,4};
//        String s = "aez";
//        int[] shifts = {1,1,3};
        String s = "abc";
        int[] shifts = {2,2,2};
        String answer = shiftLetters(s, shifts);
        System.out.println(answer);
    }

    private static String shiftLetters(String s, int[] shifts) {

        int [] shiftPos = new int[s.length()];
        for(int i = 0; i < shifts.length; i++) {
            shiftPos[shifts[i] - 1] = (shiftPos[shifts[i] - 1] + 1) % 26;
        }

        char [] charArray = s.toCharArray();
        int suffixSum = 0;
        int index = shiftPos.length - 1;
        while(index >= 0) {
            suffixSum = (suffixSum + shiftPos[index]) % 26;
            charArray[index] = (char)('a' + (charArray[index]-'a'+suffixSum) % 26);
            index--;
        }
        return new String(charArray);
    }
}
