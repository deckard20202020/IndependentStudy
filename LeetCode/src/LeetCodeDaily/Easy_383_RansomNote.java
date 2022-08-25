package LeetCodeDaily;

import java.util.HashMap;

public class Easy_383_RansomNote {
    public static void main(String[] args) {
        
        String ransomNote = "aa";
        String magazine = "b";
        boolean answer = canConstruct(ransomNote, magazine);
        System.out.println(answer);
    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        //idea
        //put all the letters of ransomNote in a hashmap with the amounts
        //scroll through ransomNote

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            Character c = magazine.charAt(i);
            if (!map.keySet().contains(c)) {
                map.put(c, 1);
            } else {
                int n = map.get(c);
                n++;
                map.put(c, n);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Character c = ransomNote.charAt(i);
            if(!map.keySet().contains(c) || map.get(c) < 1) {
                return false;
            } else {
                int n = map.get(c);
                n--;
                map.put(c, n);
            }
        }

        return true;
    }
}
