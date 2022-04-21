package ArraysAndHashing;

import java.util.HashMap;

public class ArraysAndHashing_Easy_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {

        //might be cleaner to build one hashmap for s, one hashmap for t
        //then scroll through the keys in one of the hashmaps and check
        //if the other has the key and if the values of the two hashmaps at that key are the same

        //first make sure the words are the same length
        if (t.length() != s.length()) {
            return false;
        }

        //build hashmap for s
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int n = map.get(s.charAt(i));
                n++;
                map.put(s.charAt(i), n);
            }
        }


        //scroll through the second word
        for (int j = 0; j < t.length(); j++) {
            if (!map.containsKey(t.charAt(j))) {
                return false;
            } else if(map.get(t.charAt(j)) <= 0) {
                return false;
            } else {
                int m = map.get(t.charAt(j));
                m--;
                map.put(t.charAt(j), m);
            }
        }


        return true;

    }
}
