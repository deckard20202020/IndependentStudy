package DynamicProgramming;

public class DP_Medium_152_MaximumProductSubarray {
    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
//        int[] nums = {-2, 3, -4};
//        int[] nums = {2,3,-2,4};
        int[] nums = {-3,-1,-1};

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

        for (int i = 1; i < nums.length; i++) {
            int a = nums[i] * maxTemp;
            int b = nums[i] * minTemp;

            maxTemp = Math.max(Math.max(a,b), nums[i]);
            minTemp = Math.min(Math.min(a,b), nums[i]);

            maxProduct = Math.max(maxProduct,maxTemp);
        }

        return maxProduct;
    }
}
