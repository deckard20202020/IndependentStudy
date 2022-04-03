package GoogleCodeJam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class QualifyingProblem2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleCodeJam\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());
        int caseNumber = 1;

        for (int i = 0; i < numberOfTestCases; i++) {

            //get the next three lines
            String nextLine = scanner.nextLine();
            String[] values = nextLine.split("\\s+");
            int c1 = Integer.parseInt(values[0]);
            int m1 = Integer.parseInt(values[1]);
            int y1 = Integer.parseInt(values[2]);
            int k1 = Integer.parseInt(values[3]);

            nextLine = scanner.nextLine();
            values = nextLine.split("\\s+");
            int c2 = Integer.parseInt(values[0]);
            int m2 = Integer.parseInt(values[1]);
            int y2 = Integer.parseInt(values[2]);
            int k2 = Integer.parseInt(values[3]);

            nextLine = scanner.nextLine();
            values = nextLine.split("\\s+");
            int c3 = Integer.parseInt(values[0]);
            int m3 = Integer.parseInt(values[1]);
            int y3 = Integer.parseInt(values[2]);
            int k3 = Integer.parseInt(values[3]);

            //get the minimum of each of the four colors
            int cMin = Math.min(c1,c2);
            cMin = Math.min(cMin,c3);

            int mMin = Math.min(m1,m2);
            mMin = Math.min(mMin,m3);

            int yMin = Math.min(y1,y2);
            yMin = Math.min(yMin,y3);

            int kMin = Math.min(k1,k2);
            kMin = Math.min(kMin,k3);

            int total = 1000000;
            int[] answers = new int[4];

            //put the minimums in a hashMap
            HashMap<String, Integer> minimums = new HashMap<>();
            minimums.put("C", cMin);
            minimums.put("M", mMin);
            minimums.put("Y", yMin);
            minimums.put("K", kMin);


            String key = "";

            //get the first three minimums
            for (int j = 0; j < 3; j++) {

                //find minimum in the hasmap
                int m = Integer.MAX_VALUE;
                for ( String k : minimums.keySet()) {
                    if (m > minimums.get(k)){
                        m = minimums.get(k);
                        key = k;
                    }
                }

                int value = minimums.get(key);
                //put the value in our answer
                if (key.equals("C")) {
                    answers[0] = Math.min(total,value);
                } else if ( key.equals("M")) {
                    answers[1] = Math.min(total,value);
                } else if (key.equals("Y")) {
                    answers[2] = Math.min(total,value);
                } else if (key.equals("K")) {
                    answers[3] = Math.min(total,value);
                }

                total = total - value;
                total = Math.max(total, 0);

                //remove that minimum
                minimums.remove(key);

            }

            //the last value in the hashset
            int remaining = 0;

            //put in our answer whatever we still need
            if (minimums.containsKey("C")) {
                remaining = minimums.get("C");
                answers[0] = Math.max(0,total);
            } else if (minimums.containsKey("M")) {
                remaining = minimums.get("M");
                answers[1] = Math.max(0,total);
            } else if (minimums.containsKey("Y")) {
                remaining = minimums.get("Y");
                answers[2] = Math.max(0,total);
            } else if (minimums.containsKey("K")) {
                remaining = minimums.get("K");
                answers[3] = Math.max(0,total);
            }


            //if we don't have enough left to print all three d's
            if (total > remaining) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + caseNumber + ": " + answers[0] + " " + answers[1] + " " + answers[2] + " " + answers[3]);
            }

            caseNumber++;
        }

    }
}
