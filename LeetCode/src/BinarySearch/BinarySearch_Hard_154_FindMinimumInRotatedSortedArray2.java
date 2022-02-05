package BinarySearch;

public class BinarySearch_Hard_154_FindMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {

        //check to see if nums only has one element
        if (nums.length == 1) {
            return nums[0];
        }
        //check to see if nums is not rotated
        if (nums[0] < nums[nums.length -1]) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length-1;

        while (start < end) {
            int midpoint = start + (end - start)/2;
            
            if (nums[midpoint] < nums[end]) {
                //go left
                end = midpoint;
                //we have found a duplicate
            }else if (nums[end] == nums[midpoint]){
                end = end - 1;
            } else {
                //go right
                start = midpoint + 1;
            }
        }

        return nums[start];
    }
}
