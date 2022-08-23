package BinarySearch;

public class BinarySearch_Easy_35_SearchInsertPosition {
    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        int target = 5;
        int answer = searchInsert(nums, target);
        System.out.println(answer);
    }

    private static int searchInsert(int[] nums, int target) {

        //want to use binary search-this is a sorted array
        int left = 0;
        int right = nums.length-1;
        int middle = 0;

        while (left <=right){
            middle = (left + right)/2;

            if (target < nums[middle]) {
                //go left
                right = middle -1;
            }
            else if (target > nums[middle]) {
                //go right
                left = middle + 1;
            }
            else if (target == nums[middle]) {
                //we have found it
                return middle;
            }
        }

        //we never found it
        if (target < nums[middle]){

            return middle;
        };

        return middle + 1;
    }
}
