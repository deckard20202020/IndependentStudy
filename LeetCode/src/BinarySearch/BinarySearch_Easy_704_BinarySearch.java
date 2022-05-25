package BinarySearch;


public class BinarySearch_Easy_704_BinarySearch {
    public static void main(String[] args) {

//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;

        int[] nums = {5};
        int target = 5;

        int answer = search(nums,target);
        System.out.println(answer);
    }

    private static int search(int[] nums, int target) {

        //all items in nums are unique and are in ascending order
        //Basic Binary Search O(n)
        int mid = nums.length/2;
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {

            if (nums[mid] == target) {
                return mid;
            }

            //go right
            if (nums[mid] < target) {
                left = mid + 1;
                mid = (right + left)/2;
            } else {
                //go left
                right = mid -1;
                mid = (right + left)/2;
            }

        }

        return -1;
    }

}
