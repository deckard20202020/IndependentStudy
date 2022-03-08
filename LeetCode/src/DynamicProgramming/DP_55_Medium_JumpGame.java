package DynamicProgramming;

public class DP_55_Medium_JumpGame {
    public boolean canJump(int[] nums) {
        //we will start at end of array.
        //we know we can get to the end if we are starting.
        //then we will iterate backwards through the array
        //We will keep track of the last index that we can reach
        //if we reach the beginning of the array, we are done

        //Should be O(n) since we are just iterating through the array once

        int lastIndexWeCanReach = nums.length -1;

        for (int i = nums.length -1; i >=0; i--) {
            if (i + nums[i] >= lastIndexWeCanReach) {
                lastIndexWeCanReach = i;
            }
        }

        if (lastIndexWeCanReach == 0) {
            return true;
        }

        return false;
    }
}
