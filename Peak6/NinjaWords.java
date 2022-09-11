package Peak6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NinjaWords {
    public static void main(String[] args) {
        List<String> targetWords = new ArrayList<>();
        targetWords.add("Sun");
        targetWords.add("Moon");
        targetWords.add(("Star"));
        targetWords.add("Planet");

        String sentence = "All the stars under the sky twinkle in slo mo on a clear night";

        int answer = countNinjaWords(targetWords, sentence);
        System.out.println(answer);

    }

    private static int countNinjaWords(List<String> targetWords, String sentence) {

//        for (String string : targetWords) {
//            string = string.toLowerCase();
//            int a = 0;
//        }
        List<String> tw = new ArrayList<>();
        for (int i = 0; i < targetWords.size(); i++) {
            String string = targetWords.get(i);
            string = string.toLowerCase();
            tw.add(string);
        }
        sentence = sentence.toLowerCase();
        int counter = 0;

        for (String word : tw) {
            counter = counter + isNinja(word, sentence);
        }

        return counter;
    }

    private static int isNinja(String word, String sentence) {

        Map<Character, Integer> senMap = new HashMap<>();
        for (int i = 0; i < sentence.length(); i++) {
            if (senMap.containsKey(sentence.charAt(i))) {
                int n = senMap.get(sentence.charAt(i));
                n++;
                senMap.put(sentence.charAt(i), n);
            } else {
                senMap.put(sentence.charAt(i), 1);
            }
        }

        int starsAvailable = 0;
        if (senMap.containsKey('*')) {
            starsAvailable = senMap.get('*');
        }

        int starsNeeded = 0;
        for (int i = 0; i < word.length(); i++) {
            if (!senMap.containsKey(word.charAt(i))) {
                starsNeeded++;
            }
        }

        if (starsNeeded > starsAvailable) {
            return 0;
        }

        int start = -1;
        int end = -1;
        start = sentence.indexOf(word.charAt(0));
        //end = sentence.indexOf(word.charAt(word.length() -1));
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == word.charAt(0)) {
                end = i;
            }
        }

        if(end - start > word.length() - 1) {
            return 1 + starsNeeded;
        }

        return 0;
    }
}
