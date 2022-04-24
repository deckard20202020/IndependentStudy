package GoogleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class RoundAProblem1 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleKickStart\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;

        for(int i = 0; i<numberOfTestCases; i++) {
            String target = scanner.nextLine();
            String typed = scanner.nextLine();

            String answer = findNumberOfDeletions(target, typed);

            System.out.println("Case #" + caseNumber + ": " + answer);

            caseNumber++;

        }
    }

    private static String findNumberOfDeletions(String target, String typed) {

        String answer = "";

        if(typed.length() < target.length()) {
            return "IMPOSSIBLE";
        }

        //create a hashmap of the target string
        HashMap<Character, Integer> map = new HashMap<>();

        //scroll through the typed and add all the letters
        for (int i = 0; i < typed.length(); i++) {
            if (!map.containsKey(typed.charAt(i))) {
                map.put(typed.charAt(i), 1);
            } else {
                int n = map.get(typed.charAt(i));
                n++;
                map.put(typed.charAt(i), n);
            }
        }

        //scroll through the target and see if we can get it out of the typed
        for (int j = 0; j < target.length(); j++) {
            if(map.containsKey(target.charAt(j))) {
                int n = map.get(target.charAt(j));
                n--;
                //check to see if we have run out of letters
                if(n<0) {
                    return "IMPOSSIBLE";
                }
                map.put(target.charAt(j), n);
            } else {
                return "IMPOSSIBLE";
            }
        }

        int tally =0;
        for(Character key : map.keySet()) {
            tally = tally + map.get(key);
        }

        answer = String.valueOf(tally);
        return answer;
    }
}
