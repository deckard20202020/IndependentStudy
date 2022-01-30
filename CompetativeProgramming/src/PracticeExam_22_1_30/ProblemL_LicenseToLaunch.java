package PracticeExam_22_1_30;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProblemL_LicenseToLaunch {
    public static void main(String[]args) throws FileNotFoundException {

        //ACCEPTED

//        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_1_30\\test2.txt");
//        Scanner scanner = new Scanner((file));

        Scanner scanner = new Scanner(System.in);

        //String input
        String string = scanner.nextLine();

        String[] strings = string.split("\\s+");

        int[] amountOfSpaceJunk = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            amountOfSpaceJunk[i] = Integer.parseInt(strings[i]);
        }

        int min = Integer.MAX_VALUE;
        //key = amount of junk value =  list of days with that junk
        HashMap<Integer, List<Integer>> junkAndDays = new HashMap<>();

        //iterate through the list
        for (int i = 0; i < amountOfSpaceJunk.length; i++) {
            if (junkAndDays.get(amountOfSpaceJunk[i]) == null) {
                junkAndDays.put(amountOfSpaceJunk[i], new ArrayList<Integer>());
                //update the min amount of spacejunk
                if (min > amountOfSpaceJunk[i]) {
                    min = amountOfSpaceJunk[i];
                }
            }
            junkAndDays.get(amountOfSpaceJunk[i]).add(i);
        }

        //get the list of the days with the min amount of space junk
        List<Integer> minList = junkAndDays.get(min);

        //grab the first value of the list
        System.out.println(minList.get(0));



    }
}
