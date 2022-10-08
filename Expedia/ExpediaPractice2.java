package Expedia;

public class ExpediaPractice2 {
    public static void main (String[] args) {

        int [] nums = {1,2,5,9};
        int threshold = 6;

        int answer = smallestDivisor(nums, threshold);
        System.out.println(answer);
        
    }

    private static int smallestDivisor(int[] nums, int threshold) {

        int answer = -1;
        int low = 1;
        int high = nums[0];
        //find max value of array
        for (int n : nums) {
            high = Math.max(high, n);
        }

        //iterate using binary search on the divisors
        while (low <= high) {
            int mid = (low + high) / 2;
            int result = findSum(nums, mid);

            if (result <= threshold) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private static int findSum(int[] nums, int mid) {
        int answer = 0;
        for (int n : nums) {
            answer += + Math.ceil((1.0 * n) / mid);
        }
        return answer;
    }

}
