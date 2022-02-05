package BinarySearch;

public class BinarySearch_Medium_33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        //3.
        //you then know which half the number is in
        //binary search on that half
        //logn
        //total = logn + logn = 2logn;

        //check the base case
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        //find the rotation location with binary search
        //left will be the index of the rotation
        while (left < right) {
            int midpoint = left + (right - left)/2;

            if (nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            }else{
                right = midpoint;
            }
        }

        //determine which half to search
        int start = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        //do another binary search to find the index
        while (left <= right) {
            int midpoint = left + (right - left)/2;

            if (nums[midpoint] == target) {
                return midpoint;
            }
            else if (nums[midpoint] < target) {
                //go right
                left = midpoint + 1;
            } else {
                right = midpoint -1;
            }
        }

        //if you don't find the target
        return -1;
    }
}
