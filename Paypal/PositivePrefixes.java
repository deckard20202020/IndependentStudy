package Paypal;

import java.util.Arrays;
import java.util.Collections;

public class PositivePrefixes {
    public static void main(String[] args) {

        int[] arr = {-6, 3,4, -10};
        int answer = maxPosPrefixes(arr);
        System.out.println(answer);
    }

    private static int maxPosPrefixes(int[] arr) {

        //sort the array in reverse order
        Arrays.sort(arr);

        //scroll back to front with count until we get a - number
        int count = 0;
        int sum = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            sum = sum + arr[i];
            if (sum < 0) {
                break;
            }
            count++;
        }

        return count;
    }
}
