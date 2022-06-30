package LeetCodeDaily;

import java.util.Arrays;

public class Medium_462_MinimumMovesToEqualArrayElements2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int answer = minMoves2(nums);
        System.out.println(answer);
    }

    private static int minMoves2(int[] nums) {


        //idea
        //find the mean of the sum of the array
        //average won't work here.  Imagine the array [0,0,0,0,0,0,9999999999]
        //here the avergae would cause you to change all elements of array
        //median will only require you to change one element of the array
        //To find the mean we will sort the array and take the middle element
        //if the array is even in length we should be able to take either of the "middle" elements
        //find the sum of all the differences between each array value and that average

        int sumOfArray = 0;
        int meanOfArray = 0;

        int numMoves = 0;

        int length = nums.length;

        Arrays.sort(nums);
        meanOfArray = nums[(length - 1)/2];

        for (int j = 0; j < length; j++) {
            int difference = Math.abs(nums[j] - meanOfArray);
            numMoves += difference;
        }

        return numMoves;
    }
}
