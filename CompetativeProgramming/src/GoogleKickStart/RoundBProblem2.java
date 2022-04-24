package GoogleKickStart;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoundBProblem2 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\MSinnwell\\Projects\\IndependentStudy\\IndependentStudy\\CompetativeProgramming\\src\\GoogleKickStart\\testing.txt");

        Scanner scanner = new Scanner(file);

//        Scanner scanner = new Scanner(System.in);

        int numberOfTestCases = Integer.parseInt(scanner.nextLine());

        int caseNumber = 1;


        for (int i = 0; i < numberOfTestCases; i++) {
            long n = Long.parseLong(scanner.nextLine());
            int count = 0;

            List<Long> factors = findFactors(n);
            for(Long factor: factors) {
                if(isAPalidrome(factor)){
                    count++;
                }
            }

            System.out.println("Case #" + caseNumber + ": " + count);
            caseNumber++;

        }
    }

    private static boolean isAPalidrome(Long factor) {

        if (factor <= 9) {
            return true;
        }

        String string = String.valueOf(factor);
        int left = 0;
        int right = string.length()-1;

        while(left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private static List<Long> findFactors(long n) {
        List<Long> list = new ArrayList<>();

//        for (int i = 1; i <=n; i++) {
//            if ( n%i == 0) {
//                list.add(i);
//            }
//        }

//        for(int i=1; i <= Math.sqrt(n); i++) {
//            if(n % i == 0) {
//                list.add(i);
//                list.add(n / i);
//            }
//        }

        for(long i=1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                list.add(i);
                if(n/i != Math.sqrt(n) ) {
                    list.add((n / i));
                }
            }
        }

        return list;
    }
}
