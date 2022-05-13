package ArraysAndHashing;

import java.util.Arrays;

public class ArraysAndHashing_Medium_128_LongestConsecutiveSequence {
    public static void main (String[] args) {
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {1,2,0,1};
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
//        int[] nums = {1,2,0,1};

        int answer = longestConsecutive(nums);
        System.out.println(answer);
    }

    private static int longestConsecutive(int[] nums) {

        //idea-put all the numbers in a priority queue
        //or maybe just sort them
        //go through the array and if the next number is 1 higher increment the current streak
        //if not, update the longest streak and set the current streak back to 1

        //base case checks
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        //now we know the length is at least 2
        Arrays.sort(nums);
        int longestStreak = 1;
        int tempStreak = 1;
        int currNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currNum + 1) {
                tempStreak++;
                currNum++;
            } else {
                currNum = nums[i];
                tempStreak = 1;
            }
            longestStreak = Math.max(longestStreak, tempStreak);
        }

        return longestStreak;
    }
}
