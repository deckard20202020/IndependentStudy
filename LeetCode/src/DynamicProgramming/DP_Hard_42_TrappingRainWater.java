package DynamicProgramming;

public class DP_Hard_42_TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        //int[] height = {4,2,0,3,2,5};
        int answer = trap(height);
        System.out.println(answer);
    }

    private static int trap(int[] height) {

        //idea
        //scroll through the array.
        //for each index we need to find the
        //max boundry to the left and max boundary to the right
        //if the min of those boundaries are > heights[i]
        //increment total by min(L,R) - heights[i]
        //round up to 0 because we can't trap negative water
        //how do we find the max of the boundaries to the left and to the right for each index?

        int leftBoundary = height[0];
        int rightBoundary = height[height.length - 1];

        //store the maxHeight to left of each index
        int[] leftHeights = new int[height.length];
        //store the maxheight to the right of each index
        int[] rightHeights = new int[height.length];
        //store the minimum of the leftHeights and rightHeights at each index.
        int[] minHeights = new int[height.length];

        //no boundry to the left of the first index
        leftHeights[0] = 0;
        //no boundary to the right of the last index
        rightHeights[rightHeights.length - 1] = 0;

        for (int i = 1; i < leftHeights.length; i++) {
            leftHeights[i] = leftBoundary;
            leftBoundary = Math.max(leftBoundary, height[i]);
        }

        for (int i = rightHeights.length - 2; i >=0; i--) {
            rightHeights[i] = rightBoundary;
            rightBoundary = Math.max(rightBoundary, height[i]);
        }

        for (int i = 0; i < minHeights.length; i++) {
            minHeights[i] = Math.min(rightHeights[i], leftHeights[i]);
        }

        //scroll through the array calculating of our total
        int total = 0;

        for (int i = 0; i < height.length; i++) {
            if (minHeights[i] > height[i]) {
                //here we take the max in case we are trying to add a negative number
                total = Math.max(total, total + (minHeights[i] - height[i]));
            }
        }

        return total;
    }
}
