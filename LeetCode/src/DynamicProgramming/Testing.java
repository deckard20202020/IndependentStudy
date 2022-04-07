package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testing {
    public static void main (String[] args) {

        int [] nums = {1,2,3,1};
        int answer = rob(nums);
        System.out.println(answer);
    }

    private static int rob(int[] nums) {
        //base case
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums [1]);
        }

        //make a new array to keep track of the max
        int[] max = new int[nums.length];

        //initialize that array
        max[0] = nums[0];
        max[1] = nums[1];

        //scroll through the rest of the given array
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(nums[i-2] + nums[i], max[i-1]);
        }

        //return our last value
        return max[nums.length - 1];
    }

}
