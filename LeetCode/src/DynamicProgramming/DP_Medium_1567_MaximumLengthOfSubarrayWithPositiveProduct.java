package DynamicProgramming;

public class DP_Medium_1567_MaximumLengthOfSubarrayWithPositiveProduct {
    public static void main(String[] args) {
        int[] nums = {0, 1, -2, -3, -4};
        int answer = getMaxLen(nums);
        System.out.println(answer);
    }

    private static int getMaxLen(int[] nums) {

        //we want to find the longest subarray with no 0,s and even number of -'s
        //O(n)

        //keep track of positive streak
        int pos = 0;
        //keep track of negative streak
        int neg = 0;
        //keep track of max positive streak
        int max = 0;

        //scroll through the array
        for(int n : nums) {

            if (n == 0) {
                pos = 0;
                neg = 0;
            }

            if (n > 0) {
                //extend the positive
                pos = pos + 1;
                //extend the negative
                //if we have a negative streak going
                if (neg > 0) {
                    neg = neg + 1;
                } else {
                    neg = 0;
                }
            }

            if (n < 0) {

                //keep track of the positive streak before we update it below
                int temp = pos;
                //if we have a negative streak > 0
                if (neg > 0) {
                    //update the positive streak
                    pos = neg + 1;
                } else {
                    pos = 0;
                }
                //if we have a positive streak > 0
                if (temp > 0) {
                    neg = temp + 1;
                } else {
                    neg = 1;
                }
            }

            max = Math.max(max, pos);
        }

        return max;
    }


}
