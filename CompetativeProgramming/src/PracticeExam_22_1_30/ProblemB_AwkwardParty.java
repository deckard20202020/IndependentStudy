package PracticeExam_22_1_30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProblemB_AwkwardParty {
    public static void main(String[]args) throws FileNotFoundException {

        //Accepted

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_1_30\\test.txt");
//        Scanner scanner = new Scanner((file));

        Scanner scanner = new Scanner(System.in);

        // number input
        Integer n = Integer.parseInt(scanner.nextLine());

        //String input
        String string = scanner.nextLine();

        String[] strings = string.split("\\s+");

        int[] seating = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            seating[i] = Integer.parseInt(strings[i]);
        }

        int min = Integer.MAX_VALUE;

        HashMap<Integer, List<Integer>> indexOfLanguages = new HashMap<>();
        int numberOfLanguages = 0;

        //add each element to a hashmap (key = language, value = list of indexes with that language)
        for (int i = 0; i < seating.length; i++) {
            //for each new language we encounter
            if (indexOfLanguages.get(seating[i]) == null) {
                indexOfLanguages.put(seating[i], new ArrayList<Integer>());
                //increment the number of languages
                numberOfLanguages++;
            }
            indexOfLanguages.get(seating[i]).add(i);
        }

        //check to see if the number of languages is 2 or less
        //in this case, the result would just be the number of languages.
        if (numberOfLanguages <= 2) {
            min = numberOfLanguages;
        }

        //for each language
        for(Map.Entry<Integer, List<Integer>> entry : indexOfLanguages.entrySet()) {
            int key = entry.getKey();
            List<Integer> listOfSeats = indexOfLanguages.get(key);
            //if the list has more than one entry
            if ( listOfSeats.size() > 1) {
                //scroll through the list
                for (int i = 0; i < listOfSeats.size() - 1; i++) {
                    //get the difference in values between the current and next entry
                    int temp = listOfSeats.get(i + 1) - listOfSeats.get(i);
                    //if this entry is smaller than the current minimum
                    if (temp < min) {
                        //update the minimum
                        min = temp;
                    }
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            min = numberOfLanguages;
        }

        System.out.println(min);

    }
}
