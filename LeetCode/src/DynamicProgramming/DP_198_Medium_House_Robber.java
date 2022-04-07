package DynamicProgramming;

public class DP_198_Medium_House_Robber {
    public int rob(int[] nums) {

        //1-D array
        //O(n) time

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
