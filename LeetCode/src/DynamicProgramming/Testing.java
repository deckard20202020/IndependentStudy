package DynamicProgramming;

import java.util.ArrayList;

public class Testing {
    public static void main (String[] args) {

        int n = 16;

        int answer = getMaximumGenerated(n);
        System.out.println(answer);
    }

    private static int getMaximumGenerated(int n) {

        //base cases
        if (n == 0) {
            return 0;
        }
        if ( n == 1 || n == 2) {
            return 1;
        }

        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        // array[2] = 1;

        int max = 0;

        for (int i = 1; i <= (n/2); i++) {
            array[i*2] = array[i];
            max = Math.max(max, array[i*2]);

            if ( i*2 + 1 <= n) {
                array[i*2 + 1] = array[i] + array[i+1];
            }

            max = Math.max(max, array[i*2 + 1]);
        }

        return max;

    }


}
