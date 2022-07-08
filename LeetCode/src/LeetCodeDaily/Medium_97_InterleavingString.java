package LeetCodeDaily;

import java.util.HashMap;

public class Medium_97_InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
//        String s3 = "aabbcbcac";
        String s3 = "aadbbbaccc";
        boolean answer = isInterleave(s1, s2, s3);
        System.out.println(answer);
    }

    private static boolean isInterleave(String s1, String s2, String s3) {

        //idea
        //make two maps of the characters of s1 and s2
        //for each character in s3
        //check to see if we have characters in either map left
        //if so deduct the character count in that map
        //if not return false
        //return true
        //THIS WILL NOT WORK
            //NEED TO KEEP RELATIVE ORDER OF ORIGINAL STRINGS
            //TURNS INTO A PROBLEM OF WHETHER OR NOT YOU CAN MAKE
            //THE THIRD STRING FROM SUBSTRINGS OF THE FIRST TWO STIRNGS

        //base cases
        if (s3.length() > s1.length() + s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character c = s1.charAt(i);
            if (map1.containsKey(c)) {
                int n = map1.get(c);
                n++;
                map1.put(c, n);
            } else {
                map1.put(c, 1);
            }
        }

        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            Character c = s2.charAt(i);
            if (map2.containsKey(c)) {
                int n = map2.get(c);
                n++;
                map2.put(c, n);
            } else {
                map2.put(c, 1);
            }
        }

        for (int i = 0; i < s3.length(); i++) {
            Character c = s3.charAt(i);

            if (map1.containsKey(c) && map1.get(c) > 0) {
                int n = map1.get(c);
                n--;
                map1.put(c, n);
            } else if (map2.containsKey(c) && map2.get(c) > 0) {
                int n = map2.get(c);
                n--;
                map2.put(c, n);
            }else {
                return false;
            }
        }

        return true;
    }



}
