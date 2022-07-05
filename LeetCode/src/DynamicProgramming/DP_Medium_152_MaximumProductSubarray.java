package DynamicProgramming;

public class DP_Medium_152_MaximumProductSubarray {
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
//        int[] nums = {-2, 3, -4};
//        int[] nums = {2,3,-2,4};
//        int[] nums = {-3,-1,-1};
//        int[] nums = {1, 3, -1, -4, 2, 2};
//        int[] nums = {-1,-2,-9,-6};
        int[] nums = {2,-5,-2,-4,3};

        int answer = maxProduct(nums);
        System.out.println(answer);
    }

    private static int maxProduct(int[] nums) {

        //The tricky part of this problem is :
            //the array may contain 0 and negative numbers.
        //all positives is easy, just multiply all of them
        //need to keep track of both max and minimum to handle the negative numbers
            //consider {-1,-2,-3}
        //0 will kill our streak for max and min
            //need to reset our max and our min to 1 in this case
                //don't want to kill our product

        //find the max of the array
        int result = nums[0];
        for (int n : nums) {
            result = Math.max(n, result);
        }

        //initialize curr min and max
        int currMax = 1;
        int currMin = 1;

        //scroll through the array
        for(int n : nums) {

            //handle 0 case
            if (n == 0) {
                currMin = 1;
                currMax = 1;
                continue;
            }

            //we need to save currMax for calculations below
            //we will save it
            int savedCurrMax = currMax;

            //we need to compare n * currMax, n * currMin, n
            //so we will introduce a temp variable
            int temp = Math.max(n * currMax, n * currMin);
            currMax = Math.max(temp, n);

            //do the same thing for currMin
            temp = Math.min(n * savedCurrMax, n * currMin);
            currMin = Math.min(temp, n);

            //update result
            result = Math.max(result, currMax);

        }

        return result;


        //This will not work for cases like {-2,3,-4}
//        //create a dp array
//        int[] dp = new int[nums.length];
//        //initialize the first value of the array
//        dp[0] = nums[0];
//        //initialize our maxProduct
//        int maxProduct = nums[0];
//
//        for (int i = 1; i < dp.length; i++) {
//            dp[i] = Math.max(nums[i], dp[i-1] * nums[i]);
//            maxProduct = Math.max(dp[i] , maxProduct);
//        }
//
//        return maxProduct;
//    }
    }
}
