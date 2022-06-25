package Greedy;

public class Greedy_Easy_53_MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int answer = maxSubArray(nums);
        System.out.println(answer);
}

    private static int maxSubArray(int[] nums) {

//         //Dynamic solution
//             //Time Complexity = O(n)
//             //Space Complexity = O(n)
        //Good if they want to know the start and ending of the subarray

//         int[] table = new int[nums.length];
//         int max = nums[0];
//         table[0] = nums[0];

//         for (int i = 1; i < nums.length; i++) {
//             table[i] = Math.max(nums[i], nums[i] + table[i-1]);
//             max = Math.max(max, table[i]);
//         }
//         return max;

        //Iterative solution
        //Time Complexity = O(n)
        //Space Complexity smaller than Dynamic Solution
        //We don't need the extra table
        int max = nums[0];
        int current = max;

        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], nums[i] + current);
            max = Math.max(max, current);
        }
        return max;
    }
}