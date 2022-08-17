package LeetCodeDaily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Easy_804_UniqueMorseCodeWords {
    public static void main(String[] args) {

        String[] words = {"rwjje","aittjje","auyyn","lqtktn","lmjwn"};
        int answer = uniqueMorseRepresentations(words);
        System.out.println(answer);
    }

    private static int uniqueMorseRepresentations(String[] words) {

        //idea
        //put all the letters into a map
        //scroll through the words and build the new word.
        //put the words in a set
        //return the size of the set

        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('i', "..");
        map.put('j', ".---");
        map.put('k', "-.-");
        map.put('l', ".-..");
        map.put('m', "--");
        map.put('n', "-.");
        map.put('o', "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");

        for (String word : words) {
            String mWord = "";
            for (int i = 0; i < word.length(); i++) {
                String m = map.get(word.charAt(i));
                mWord = mWord + m;
            }

            set.add(mWord);

        }

        return set.size();
    }
}
