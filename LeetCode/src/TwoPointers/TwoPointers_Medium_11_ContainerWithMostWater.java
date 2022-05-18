package TwoPointers;

public class TwoPointers_Medium_11_ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {2,3,10,5,7,8,9};
        int answer = maxArea(height);
        System.out.println(answer);
    }

    private static int maxArea(int[] height) {

        //O(n)

        //n is at least two

        //idea
        //left pointer and right pointer
        //use a while loop and update max volume as you go
        //we can scroll through the index only once.
        //update the smaller pointer
            //this update is the only one that might give us a larger value

        int left = 0;
        int right = height.length - 1;
        int answer = 0;

        while (left < right) {
            int maxHeight = Math.min(height[left], height[right]);
            int base = right - left;
            int vol = maxHeight * base;
            //update answer
            answer = Math.max(answer, vol);
            //update the pointers
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return answer;
    }
}
