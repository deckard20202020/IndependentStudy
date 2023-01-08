package SlidingWindow;

public class SlidingWindow_Medium_1004_MaxConsecutiveOnes3 {
    public static void main(String[] args) {
        
//        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
//        int k  = 2;

        int[] nums = {1,0,1,0,1,0,1};
        int k = 1;
        
        int answer = longestOnes(nums, k);
        System.out.println(answer);
    }

    private static int longestOnes(int[] nums, int k) {

        int left = 0;
        int right = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }

                left++;
            }

            right++;
        }

        return right - left;
    }
}
