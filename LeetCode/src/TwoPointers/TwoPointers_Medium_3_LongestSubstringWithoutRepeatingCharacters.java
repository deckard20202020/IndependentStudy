package TwoPointers;

import java.util.HashMap;

public class TwoPointers_Medium_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        String s = "abcabcdd";
//        String s ="pwwkew";
        String s = "dvdf";
//        String s = "aab";
        int answer = lengthOfLongestSubstring(s);
        System.out.println(answer);
    }

    private static int lengthOfLongestSubstring(String s) {

        //base cases
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        //idea
        //turn the string into an array
        //scroll through the array putting elements in a hashmap as we go
        //key = character value = index
        //if we find a character in hashmap
        //move the window
        //value should be value in hashmap + 1

        int answer = 0;
        int temp = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //check to see if the character is a duplicate
            if (!map.keySet().contains(c)) {
                map.put(c,i);
                temp++;
                answer = Math.max(temp, answer);

            } else {
                //slide the window
                i = map.get(c);
                //update the result
                answer = Math.max(answer, temp);
                //update the temp
                temp = 0;
                //we need to update the hashmap here
                map.clear();
            }
        }


        return answer;
    }
}
