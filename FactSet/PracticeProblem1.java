package FactSet;

import java.util.Arrays;

public class PracticeProblem1 {
    public static void main (String[] args) {

        double[] weights = {1.99, 1.01, 2.5, 1.5, 1.01};
        double max = 3.0;
        int answer = getMinTrips(weights, max);
        System.out.println(answer);
    }

    private static int getMinTrips(double[] weights, double max) {

        //sort the array
        Arrays.sort(weights);

        int count = 0;
        int left = 0;
        int right = weights.length - 1;

        while (left <= right) {

            //there is only one bag left
            if (left == right) {
                count++;
                break;
            }

            if (weights[left] + weights[right] <= max) {
                //we can carry both
                left++;
                right--;
                count++;
            } else {
                //we can only carry one
                right--;
                count++;
            }
        }

        return count;

    }
}
