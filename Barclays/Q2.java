package Barclays;
import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k  = 2;

//        int[] nums = {1,0,1,0,1,0,1};
//        int k = 1;

        int longestWindow = longestOnes(nums, k);
        System.out.println(longestWindow);
//        int numberOfLongestWindows = findNumberOfLongestWindows(nums, k, longestWindow);
//        System.out.println(numberOfLongestWindows);
    }

//    private static int findNumberOfLongestWindows(int[] nums, int k, int longestWindow) {
//
//        int left = 0;
//        int right = longestWindow;
//        int counter = 0;
//
//        while (right < nums.length) {
//            int[] window = Arrays.copyOfRange(nums, left, right);
//            int numZeros =
//        }
//    }

    private static int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;
        int maxLength = Integer.MIN_VALUE;
        int counter = 0;

        while (right < nums.length) {

//            //check the max length
//            if (right - left >= maxLength) {
//                //update the count
//
//                counter = updateCount(right, left, maxLength, counter);
//                maxLength = Math.max(maxLength, right - left);
//            }

            //decrement the amount of zeros we have left to spare
            if (nums[right] == 0) {
                k--;
            }

            //move the left pointer
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }

                left++;
            }



            right++;

            if (k >= 0) {

                //if we have found a same max length
                if (right - left == maxLength) {
                    counter ++;
                }

                //if we have found a new max length
                if (right - left > maxLength) {
                    counter = 1;
                    maxLength = right - left;
                }

            }

        }

//        return right - left;
        return counter;
    }

    private static int updateCount(int right, int left, int maxLength, int counter) {

        //if left - right is same as max length
        if (right - left == maxLength) {
            //increase the number
            counter++;
        }

        //if left - right is larger
        if (right - left > maxLength) {
            //reset the counter
            counter = 1;
        }

        return counter;
    }
}
