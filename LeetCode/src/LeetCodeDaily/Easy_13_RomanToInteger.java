package LeetCodeDaily;

import java.util.HashMap;

public class Easy_13_RomanToInteger {
    public static void main(String[] args) {

        String s = "MCMXCIV";
        int answer = romanToInt(s);
        System.out.println(answer);
    }

    private static int romanToInt(String s) {

        //idea
        //put the values in a map key = character, value = Integer
        //scroll through the string adding the amount.

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {

                sum = sum - map.get(s.charAt(i));
            } else {

                sum = sum + map.get(s.charAt(i));
            }
        }

        return sum + map.get(s.charAt(s.length() - 1));

    }
}
