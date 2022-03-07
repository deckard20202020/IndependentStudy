package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Testing {
    public static void main (String[] args) {
        int[] input = {1,100,1,1,1,100,1,1,100,1};

        int answer = (minCostClimbingStairs(input));

        System.out.println(answer);
    }

    private static int minCostClimbingStairs(int[] cost) {

        //base case
        if (cost.length <= 2) {
            return Math.min(cost[0],cost[1]);
        }

        int[] total = new int[cost.length];
        total[0] = cost[0];
        total[1] = cost[1];

        for (int i = 2; i < total.length; i++) {
            total[i] = Math.min(total[i-1], total[i-2] + cost[i]);
        }

        return Math.min(total[total.length -1], total[total.length - 2]);
    }


}
