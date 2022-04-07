package DynamicProgramming;

public class DP_213_Medium_HouseRobber2 {
    public int rob(int[] nums) {

        //O(n)

        //check base cases
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //initialize our array
        int[]max = new int[nums.length];
        max[0] = nums[0];
        max[1] = nums[1];

        //better way to do this might be to make two new arrays
        //one starts at 1 and goes to end
        //other starts at 0 and goes to end-1
        //take the max of these two values
        //like doing HouseRobber two times

        int[] withOutFirst = new int[nums.length-1];
        for (int i = 1; i < nums.length; i++) {
            withOutFirst[i-1] = nums[i];
        }

        int[] withOutLast = new int[nums.length-1];
        for (int i = 0; i < nums.length - 1; i++) {
            withOutLast[i] = nums[i];
        }

        int noFirst = findMax(withOutFirst);
        int noLast = findMax(withOutLast);

        return Math.max(noFirst, noLast);

    }

    private static int findMax(int[] nums) {
        //check base cases
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //initialize our array
        int[]max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);

        //better way to do this might be to make two new arrays
        //one starts at 1 and goes to end
        //other starts at 0 and goes to end-1
        //take the max of these two values

        //scroll through the rest of the array and update
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i-2] + nums[i], max[i-1]);
        }

        return max[nums.length - 1];
    }
}
