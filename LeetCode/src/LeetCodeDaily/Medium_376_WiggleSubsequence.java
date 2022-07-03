package LeetCodeDaily;

public class Medium_376_WiggleSubsequence {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9};
        int answer = wiggleMaxLength(nums);
        System.out.println(answer);

    }

    private static int wiggleMaxLength(int[] nums) {

        //idea
        //scroll through the array and count the number of times the slope oscilates
        //O(n) since we just scroll through the array once

        //base case
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        //we know we are at least length 2
        int prevDiff = nums[1] - nums[0];
        int count;
        if (prevDiff == 0) {
            count = 1;
        } else {
            count = 2;
        }

        //scroll through the array
        for (int i = 2; i < nums.length; i++) {
            //calculate the current difference
            int currDiff = nums[i] - nums[i - 1];
            if ((currDiff > 0 && prevDiff <= 0) || (currDiff < 0 && prevDiff >= 0)) {
                count++;
                prevDiff = currDiff;
            }
        }

        return count;
    }
}
