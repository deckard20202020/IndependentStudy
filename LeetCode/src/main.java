public class main {

    public static void main (String args[]) {
        //int[] array = {4,5,6,7,0,1,2};
        //int[] array = {11,13,15,17};
        //[11,13,15,17]
        int[] array = {2,1};

        int index = findMin(array);

        System.out.println(index);



    }

    private static int findMin(int[] nums) {

        //find where the array has been rotated.
        //can use a binary search
        //return the index at location of rotation

        //edge case checks
        //Don't need to check null or 0 length bc length >= 1
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1 ;
        int length = nums.length;
        int location = -1;

        //need to check to see if the array isn't rotated
        if (nums[length - 1] > nums[0]) {
            return nums[0];
        }

        while (left <= right) {
            int midpoint = left + (right - left)/2;

            //have we found it?
            if (nums[midpoint] < nums[midpoint-1]) {
                //if (nums[midpoint] <= nums[length -1] && nums[midpoint] >= nums[0]) {
                return nums[midpoint];
            } else if (nums[midpoint] > nums[length-1]){
                //go right
                left = midpoint + 1;
            } else {
                //go left
                right = midpoint - 1;
            }
        }

        return 1;
    }

}

