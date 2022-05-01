package PracticeExam_22_5_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ProblemB {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\PracticeExam_22_5_1\\tests.txt");
        Scanner scanner = new Scanner((file));
//
//        Scanner scanner = new Scanner(System.in);
//
        // number of test cases
        Integer numberOfTestCases = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfTestCases; i++) {
            String cl = scanner.nextLine();
            String[] cls = cl.split("\\s+");
            //get the target location
            double xTarLoc = Double.parseDouble(cls[0]);
            double yTarLoc = Double.parseDouble(cls[1]);

            //store candle locations
            HashMap<Integer, List<Double>> map = new HashMap<>();
            int numberOfCandles = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < numberOfCandles; j++) {
                String l = scanner.nextLine();
                String[] lSeparated = l.split("\\s+");
                List<Double> candleCoors = new ArrayList<>();
                candleCoors.add(0, Double.parseDouble(lSeparated[0]));
                candleCoors.add(1, Double.parseDouble(lSeparated[1]));
                map.put(j, candleCoors);
            }

            //find our answer
            boolean answer = findOurAnswer(xTarLoc, yTarLoc, map);
            if (answer) {
                System.out.println("light a candle");
            } else {
                System.out.println("curse the darkness");
            }


        }
    }

    private static boolean findOurAnswer(double xTarLoc, double yTarLoc, HashMap<Integer, List<Double>> map) {

        for (Integer candleNumber : map.keySet()) {
            List list = map.get(candleNumber);
            double x = (double) list.get(0);
            double y = (double) list.get(1);

            //find the dist between target and candidate
            double dist = findDist(xTarLoc, yTarLoc, x, y);

            if (Math.sqrt(dist) <=8 ) {
                return true;
            }

        }

        return false;
    }

    public static double findDist(double x1, double y1, double x2, double y2) {
        double answer = Math.pow((x1-x2),2) + Math.pow(y1-y2,2);
        return answer;
    }

}
