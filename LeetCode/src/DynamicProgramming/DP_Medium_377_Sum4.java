package DynamicProgramming;

public class DP_Medium_377_Sum4 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        int answer = combinationSum4(nums, target);
        System.out.println(answer);
    }

    private static int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            int count = 0;
            for(int n : nums) {
                if (n > i) {
                    continue;
                } else if (n == i) {
                    count++;
                } else {
                    count = count + dp[i - n];
                }
            }

            dp[i] = count;
        }

        return dp[target];
    }
}
