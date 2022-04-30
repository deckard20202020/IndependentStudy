package DynamicProgramming;

public class DP_Medium_152_MaximumProductSubarray {
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
        int[] nums = {-2, 3, -4};
//        int[] nums = {2,3,-2,4};
//        int[] nums = {-3,-1,-1};
//        int[] nums = {1, 3, -1, -4, 2, 2};

        int answer = maxProduct(nums);
        System.out.println(answer);
    }

    private static int maxProduct(int[] nums) {

//        The tricky part of this problem is : the array may contain 0 and negative numbers.
//        To make solution simple, the trick is to use two current max value, one for positive
//        and one for negative. The negative one is actually min value of the product.
//        When comparing, don’t forget to consider the ith element itself.

        //base case
        if (nums.length == 1) {
            return nums[0];
        }

        int maxProduct = nums[0];
        int maxTemp = nums[0];
        int minTemp = nums[0];

        //scroll through the list of numbers
        for (int i = 1; i < nums.length; i++) {
            int a = maxTemp * nums[i];
            int b = minTemp * nums[i];

            //update our maxTemp
            maxTemp = Math.max(Math.max(a, b), nums[i]);
            minTemp = Math.min(Math.min(a, b), nums[i]);

            //update our maxProduct
            maxProduct = Math.max(maxProduct, maxTemp);
        }

        return maxProduct;


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
