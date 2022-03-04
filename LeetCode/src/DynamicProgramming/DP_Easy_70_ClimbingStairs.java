package DynamicProgramming;

public class DP_Easy_70_ClimbingStairs {
    public int climbStairs(int n) {

        //this is basically fibonacci numbers

        //base cases
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        //array needs to be one larger
        int[] total = new int[n + 1];

        //set the initicial values
        total[0] = 0;
        total[1] = 1;
        total[2] = 2;

        //should make it O(n)
        for (int i =3; i < total.length; i++) {
            total = numberOfWays(i, total);
        }

        return total[total.length-1];

    }

    public int[] numberOfWays(int i, int[] total) {
        total[i] = total[i-1] + total[i-2];
        return total;
    }
}
