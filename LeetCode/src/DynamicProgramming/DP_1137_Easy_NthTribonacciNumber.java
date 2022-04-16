package DynamicProgramming;

public class DP_1137_Easy_NthTribonacciNumber {
    public int tribonacci(int n) {

        //this is just like the fibonacci sequence
        //only difference is we need to set the first 3 instead of the first 2

        if (n == 0) {
            return 0;
        }

        if (n == 1 || n ==2) {
            return 1;
        }

        int[] array = new int[n+1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;

        for (int i = 3; i <= n; i++) {
            array[i] = array[i-1] + array[i-2] + array[i-3];
        }

        return array[n];

    }
}
