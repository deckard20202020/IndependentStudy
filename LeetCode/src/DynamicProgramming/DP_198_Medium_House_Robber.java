package DynamicProgramming;

public class DP_198_Medium_House_Robber {
    public static void main(String[] args){
        //int [] nums = {2,7,9,3,1};
        int[] nums = {2,1,1,2};
        int answer = rob(nums);
        System.out.println(answer);
    }
    public static int rob(int[] nums) {

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
        max[1] = Math.max(nums[0],nums[1]);

        //scroll through the rest of the given array
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i-2] + nums[i], max[i-1]);
        }

        //return our last value
        return max[nums.length - 1];

    }
}
