package DynamicProgramming;

public class DP_Medium_413_ArithmeticSlices {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        //int[] nums = {1, 2, 3};
        //int[] nums = {1,2,3,8,9,10};
        //int[] nums = {2,1,3,4,2,3};
        int answer = numberOfArithmeticSlices(nums);
        System.out.print(answer);
    }

    private static int numberOfArithmeticSlices(int[] nums) {

        //idea
        //scroll through the array counting the number
        //of arithmetic slices at each index of the array
        //if we find an arithmetic slice at an index
        //the number of arithmetic slices at that index i
        //is 1 + dp[i-1]

        int total = 0;
        int[] dp = new int[nums.length];

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            total = total + dp[i];
        }

        return total;
    }
}
