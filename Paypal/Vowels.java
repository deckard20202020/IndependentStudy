package Paypal;

import java.util.HashSet;

public class Vowels {
    public static void main(String[] args) {

        String[] strArr = {"aba", "bcb", "ece", "aa", "e"};
        String[] queries = {"1-3", "2-5", "2-2"};
        int[] answer = findVowels(strArr, queries);
        for (int n : answer) {
            System.out.println(n);
        }
    }

    private static int[] findVowels(String[] strArr, String[] queries) {

        int[] answer = new int[queries.length];

        //set of vowels.
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        //scroll through the queries
        for (int j = 0; j < queries.length; j++) {
            String[] splitString = queries[j].split("-");
            int first = Integer.valueOf(splitString[0]);
            int second = Integer.valueOf(splitString[1]);

            int count = 0;

            //scroll through the string array
            for (int i = first; i <= second; i++) {
                String word = strArr[i - 1];
                if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1))) {
                    count++;
                }
            }

            answer[j] = count;

        }

        return answer;
    }
}
