package DynamicProgramming;

public class DP_Medium_918_MaximumSumCircularSubarray {
    public static void main(String[] args) {
        //int[] nums = {1,-2,3,-2};
        int[] nums = {5, -3, 5};
        int answer = maxSubarraySumCircular(nums);
        System.out.println(answer);
    }

    private static int maxSubarraySumCircular(int[] nums) {

        //idea
        //we can use a helper method to find the maximum sum of an array
        //The array we will use is twice as long as the original array
        //the new array will be just two copies of the original put together
        //But we will find the max in a window of size nums.length
        //This idea is bad for large arrays


//        int window = nums.length;
//        int[] bigArray = new int[2 * window];
//        //initialize new array
//        for (int i = 0; i < bigArray.length; i++) {
//            bigArray[i] = nums[i % window];
//        }
//
//        return helper(bigArray, window);

        //idea2
        //We will calculate the maxSum, minSum, and sum
        //We will return the max of the maxSum and (sum - minSum)
        // O(n) time | O(1) space

        //We can NOT assume that maxSum = sum of all elements - minSum
            //Case 1 there are more than 2 arrays that both have minSum
                //nums = {1,-3,4,5,-1,4,-3}
                //sum = 5
                //but maxSum = 5 - (-3) = 9.  Actual maxSum = 9
                //here the maxSum is > than sum - minSum so we return maxSum
            //Case 2
                //nums[] only contains negative numbers
                //nums = {-1,-2,-3,-4,-5}
                //here sum = minSum, so the largest number will be our maxSum
                    //so if sum == minSum, we will want to return maxSum

        int curMax = nums[0], maxSum = nums[0];
        int curMin = nums[0], minSum = nums[0];
        int sum = nums[0];

        for(int i = 1; i < nums.length; i++)
        {
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(minSum, curMin);
            sum += nums[i];
        }

        //in case the array contains only negative numbers
        if (sum == minSum) {
            return maxSum;
        }

        return Math.max(maxSum, sum - minSum);
    }
//
//    private static int helper(int[] bigArray, int window) {
//
//
//        int max = bigArray[0];
//
//        for (int i = 0; i < bigArray.length; i++) {
//            int currMax = bigArray[i];
//            if (i + window < bigArray.length) {
//                for (int j = 1; j < window; j++) {
//                    currMax = Math.max(bigArray[i + j] + currMax, bigArray[i + j]);
//                    max = Math.max(max, currMax);
//                }
//            }
//        }
//
//        return max;
//    }
}
