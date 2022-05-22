package SlidingWindow;

import java.util.HashMap;

public class SlildingWindow_Medium_424_LongestRepeatingCharacterReplacement {
    public static void main (String[] args) {
//        String s = "ABAB";
//        int k = 2;
//        String s = "AABABBA";
//        int k = 1;
//        String s = "AAAA";
//        int k = 2;
//        String s = "AAAB";
//        int k = 0;
        String s = "AABABBA";
        int k = 1;

        int answer = characterReplacement(s, k);
        System.out.println(answer);
    }

    private static int characterReplacement(String s, int k) {

        //base cases
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        //idea
        //iterate through the word putting each element into a hashmap
        int start = 0;
        int maxLength = 0;
        int maxRepeatLetterCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            //rightChar
            char rightChar = s.charAt(i);
            //key = character value = letter count
            if (map.containsKey(rightChar)) {
                int n = map.get(rightChar);
                n++;
                map.put(rightChar, n);
            } else {
                map.put(rightChar, 1);
            }

            //update the maxRepeatLetterCount
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, map.get(rightChar));

            //if(end-start+1-maxRepeatLetterCount > k)
            if (i - start + 1 - maxRepeatLetterCount > k) {
                //assign a leftChar = start
                char leftChar = s.charAt(start);
                //update map
                map.put(leftChar, map.get(leftChar) - 1);
                //move the start of the window
                start++;
            }

            //update the maxLength
            maxLength = Math.max(maxLength, i - start + 1);

        }

        return maxLength;

    }
}
