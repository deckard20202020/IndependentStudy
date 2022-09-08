package Peak6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KangarooWords {
    public static void main(String[] args) {

        String[] words = {"illiuminated", "animosity","deoxyribonucleic", "container", "lit", "amity", "encourage", "lighted"};
        String[] wordsToSynonyms = {"encourage:urge,boost,inspire", "container:tin,can,bag,bottle","lighted:lit","illuminated:lit"};
        String[] wordsToAntonyms = {"encourage:discourage", "animosity:amity,like","lighted:dark"};

        int answer = kangarooWords(words, wordsToSynonyms, wordsToAntonyms);

        System.out.println(answer);
    }

    private static int kangarooWords(String[] words, String[] wordsToSynonyms, String[] wordsToAntonyms) {
        int answer = 0;

        //case insensitive
        caseInsensitive(words);
        caseInsensitive(wordsToSynonyms);
        caseInsensitive(wordsToAntonyms);

        Map<String, Integer> synDict = new HashMap<>();
        for (String pair : wordsToSynonyms) {
            String[] pairs = pair.split(":");
            String word = pairs[0];
            String S = pairs[1];
            String[] synonyms = S.split(",");
            for (String synonym : synonyms) {
                if (isKangaroo(word, synonym)) {
                    if (synDict.containsKey(synonym)) {
                        int i = synDict.get(synonym);
                        i++;
                        synDict.put(synonym, i);
                    } else {
                        synDict.put(synonym, 1);
                    }
                    answer++;
                }
            }
        }

        for (String key : synDict.keySet()) {
            int value = synDict.get(key);
            if (value > 1) {
                answer = answer + (value * (value - 1) / 2);
            }
        }

        Map<String, Integer> antDict = new HashMap<>();
        for (String pair : wordsToAntonyms) {
            String[] pairs = pair.split(":");
            String word = pairs[0];
            String S = pairs[1];
            String[] antonyms = S.split(",");
            for (String antonym : antonyms) {
                if (isKangaroo(word, antonym)) {
                    if (antDict.containsKey(antonym)) {
                        int i = antDict.get(antonym);
                        i++;
                        antDict.put(antonym, i);
                    } else {
                        antDict.put(antonym, 1);
                    }
                    answer--;
                }
            }
        }

        for (String key : antDict.keySet()) {
            int value = antDict.get(key);
            if (value > 1) {
                answer = answer + (value * (value - 1) / 2);
            }
        }


        return answer;
    }

    private static boolean isKangaroo(String word, String synonym) {

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            if (counter.containsKey(word.charAt(i))) {
                int j = counter.get(word.charAt(i));
                j++;
                counter.put(word.charAt(i), j);
            } else {
                counter.put(word.charAt(i), 1);
            }
        }

        for (int k = 0; k < synonym.length(); k++) {
            char c = synonym.charAt(k);
            if (!counter.containsKey(c)) {
                return false;
            }
        }
        int start = -1;
        int end = -1;
        start = word.indexOf(synonym.charAt(0));
        end = word.indexOf(synonym.charAt(synonym.length() - 1));

        if (start == -1 || end == -1) {
            return false;
        }
        return (!((end - start + 1) == synonym.length()));
    }

    private static void caseInsensitive(String[] words) {

        for(String string : words) {
            string = string.toLowerCase();
        }
    }

}
