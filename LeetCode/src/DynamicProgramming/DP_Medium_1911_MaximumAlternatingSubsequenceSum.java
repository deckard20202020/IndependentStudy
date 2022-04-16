package DynamicProgramming;

public class DP_Medium_1911_MaximumAlternatingSubsequenceSum {
    private static int maxAlternatingSum(int[] nums) {

        //I do not truly understand why this solution works
        //Found this online
        //Need to return to this and review it again.

        int sumEven = 0;
        int sumOdd = 0;

        for (int i = nums.length -1; i >=0; i--) {
            int tempEven = Math.max(sumOdd + nums[i], sumEven);
            int tempOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven = tempEven;
            sumOdd = tempOdd;
        }

        return sumEven;
    }
}
