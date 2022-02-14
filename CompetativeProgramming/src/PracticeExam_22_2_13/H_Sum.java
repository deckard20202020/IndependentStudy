package PracticeExam_22_2_13;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class H_Sum {
    public static void main(String[]args) throws FileNotFoundException {


        //sum of all numbers between 1 and n
        Scanner scanner = new Scanner(System.in);

        // number input
        Integer n = Integer.parseInt(scanner.nextLine());
//        int n = -3;

        int answer;

        answer= findTheSum(n);

        System.out.println(answer);

    }

    private static int findTheSum(int n) {
        int answer = 0;

        if(n >0) {
            for (int i = 1; i <=n; i++){
                answer = answer + i;
            }
        } else {
            for (int i = 1; i >=n; i--){
                answer = answer + i;
            }
        }

        return answer;
    }

}
