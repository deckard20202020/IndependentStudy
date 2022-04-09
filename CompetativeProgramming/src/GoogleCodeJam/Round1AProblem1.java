package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Round1AProblem1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            String word = scanner.nextLine();

            String newWord = findWord(word);

            System.out.println("Case #" + caseNumber + ": " + newWord);

            caseNumber++;

        }
    }

    private static String findWord(String word) {
        String answer = word;

//        String newWord = "";

        for (int i  = 0; i < answer.length(); i++) {
//            char letter = word.charAt(i);

            String newWord = "";

            //add the new word to a list
            List<Character> list = new ArrayList<>();
            for (int k = 0; k < answer.length(); k++) {
                list.add(k, answer.charAt(k));
            }

            //add the new character
            for (int j = 0; j < answer.length(); j++) {
                if (j == i) {
                    list.add(j, answer.charAt(j));
                }
            }

            //make the new word
            for (int n = 0; n < list.size(); n++) {
                newWord = newWord + list.get(n);
            }

            //update the answer
            if (newWord.compareTo(answer) < 0) {
                answer = newWord;
                i++;
            }
        }

        return answer;
    }
}
