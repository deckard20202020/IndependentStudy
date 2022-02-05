package BinarySearch;

public class BinarySearch_Medium_34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];

        //check for empty array
        if(nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        //look for the first instance
        result[0] = firstInstance(nums, target);

        //look for the last instance
        result[1] = lastInstance(nums, target);

        return result;
    }

    public int firstInstance(int[] nums, int target) {
        //initialize the index
        int index = -1;
        //initialize variables for your while
        int start = 0;
        int end = nums.length-1;

        //note here we need a <=
        while (start <= end) {
            int midpoint = start + (end - start) /2;

            if (nums[midpoint] >= target) {
                //search left
                end = midpoint - 1;
            } else {
                start = midpoint + 1;
            }

            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }

        return index;

    }

    public int lastInstance(int[] nums, int target) {
        //initialize the index
        int index = -1;
        //initialize variables for your while
        int start = 0;
        int end = nums.length-1;

        //note here we need a <=
        while (start <= end) {
            int midpoint = start + (end - start) /2;

            if (nums[midpoint] <= target) {
                //search right
                start = midpoint + 1;
            } else {
                end = midpoint - 1;
            }

            if (nums[midpoint] == target) {
                index = midpoint;
            }
        }

        return index;

    }
}