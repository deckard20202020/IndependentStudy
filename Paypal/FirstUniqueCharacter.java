package Paypal;

import java.util.HashMap;

public class FirstUniqueCharacter {
    public static void main(String[] args) {

        String s = "leetcode";
        int answer = getUniqueCharacter(s);
        System.out.println(answer);
    }

    private static int getUniqueCharacter(String s) {

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
                return i + 1;
            }
        }

        return -1;
    }
}
