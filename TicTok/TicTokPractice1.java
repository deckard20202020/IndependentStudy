package TicTok;

import java.util.HashMap;
import java.util.HashSet;

public class TicTokPractice1 {
    public static void main(String[] args) {

        String a = "hello";
        String b = "hello";
        boolean answer = canMake(a, b);
        System.out.println(answer);
    }

    private static boolean canMake(String a, String b) {

        //base case
        if (a.length() != b.length()) {
            return false;
        }

//        HashMap<Character, Integer> alphabet = makeAlphabet();

        //key = character, value = number
//        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
//            if (aMap.containsKey(a.charAt(i))) {
//                int n = aMap.get(a.charAt(i));
//                n++;
//                aMap.put(a.charAt(i), n);
//            } else {
//                aMap.put(a.charAt(i), 1);
//            }

            if (bMap.containsKey(b.charAt(i))) {
                int n = bMap.get(b.charAt(i));
                n++;
                bMap.put(b.charAt(i), n);
            } else {
                bMap.put(b.charAt(i), 1);
            }
        }

        HashSet<Character> missingLetters = new HashSet<>();

        //scroll through a
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                int n = bMap.get(a.charAt(i));
                n--;
                bMap.put(a.charAt(i), n);
                continue;
            } else {
                missingLetters.add(a.charAt(i));
            }
        }

        for (Character c : missingLetters) {
            Character d = c++;
//            //if I can increment down
//            Character e = c--;
            if (bMap.containsKey(d) && bMap.get(d) > 0) {
                int n = bMap.get(d);
                n--;
                bMap.put(d, n);
            } else if ((bMap.containsKey(c) && bMap.get(c) > 0)) {
                int n = bMap.get(c);
                n--;
                bMap.put(c, n);
//            } else if (bMap.containsKey(e) && bMap.get(e) > 0) {
//                int n = bMap.get(e);
//                n--;
//                bMap.put(e, n);
            } else {
                return false;
            }
        }

        return true;
    }

    private static HashMap<Character, Integer> makeAlphabet() {

        HashMap<Character, Integer> alphabet = new HashMap<>();
        alphabet.put('a', 1);
        alphabet.put('b', 1);
        alphabet.put('c', 1);
        alphabet.put('d', 1);
        alphabet.put('e', 1);
        alphabet.put('f', 1);
        alphabet.put('g', 1);
        alphabet.put('h', 1);
        alphabet.put('i', 1);
        alphabet.put('j', 1);
        alphabet.put('k', 1);
        alphabet.put('l', 1);
        alphabet.put('m', 1);
        alphabet.put('n', 1);
        alphabet.put('o', 1);
        alphabet.put('p', 1);
        alphabet.put('q', 1);
        alphabet.put('r', 1);
        alphabet.put('s', 1);
        alphabet.put('t', 1);
        alphabet.put('u', 1);
        alphabet.put('v', 1);
        alphabet.put('w', 1);
        alphabet.put('x', 1);
        alphabet.put('y', 1);
        alphabet.put('z', 1);

        return alphabet;
    }
}
