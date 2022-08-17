package LeetCodeDaily;

import java.util.HashMap;

public class Easy_387_FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int answer = firstUniqChar(s);
        System.out.println(answer);
    }

    private static int firstUniqChar(String s) {

        //idea
        //put the letters in a map
        //key = letter value = amount
        //scroll through and find the letter that only has one occurance

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int n = map.get(c);
                n++;
                map.put(c, n);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
