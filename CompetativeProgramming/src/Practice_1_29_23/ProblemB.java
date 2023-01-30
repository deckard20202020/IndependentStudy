package Practice_1_29_23;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemB {


    public static void main(String[] arg) throws FileNotFoundException {
        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\Practice_1_29_23\\test.txt");
        Scanner scanner = new Scanner((file));

//        Scanner scanner = new Scanner(System.in);

        // number input
        Integer numberOfCategories = Integer.parseInt(scanner.nextLine());

        //hashmap key = word, value = set of categories
        HashMap<String, Set<String>> mapOfWordsToCategories = new HashMap<>();
        HashMap<String, Integer> mapOfCategoriesToCount = new HashMap<>();

        //make the categories and their map
        for (int i = 0; i < numberOfCategories; i++) {
            String line = scanner.nextLine();
            String[] words = line.split("\\s+");
            for (int j = 2; j < Integer.valueOf(words[1]); j++) {
                if (mapOfWordsToCategories.containsKey(words[j])) {
                    Set<String> set = mapOfWordsToCategories.get(words[j]);
                    set.add(words[j]);
                    mapOfWordsToCategories.put(words[0], set);
                } else {
                    Set<String> set = new HashSet<>();
                    set.add(words[j]);
                    mapOfWordsToCategories.put(words[0], set);
                }
            }
            mapOfCategoriesToCount.put(words[0], 0);
        }

        String word = "";
        //grab the paragraph
        while(scanner.hasNext()) {
            word = scanner.next();
            //process the word
            if (mapOfWordsToCategories.containsKey(word)) {
                Set<String> set = mapOfWordsToCategories.get(word);
                for (String category : set) {
                    int n = mapOfCategoriesToCount.get(category);
                    n++;
                    mapOfCategoriesToCount.put(category,n);
                }
            }
        }

        while (!mapOfCategoriesToCount.isEmpty()) {
            int n = getHighestCount(mapOfCategoriesToCount);
        }
    }

    private static int getHighestCount(HashMap<String, Integer> mapOfCategoriesToCount) {

        int high = Integer.MIN_VALUE;
        for (String key : mapOfCategoriesToCount.keySet()) {
            high = Math.max(high, mapOfCategoriesToCount.get(key));
        }

        return high;
    }
}
