package Walmart;

public class NonDecreasing {
    public static int maxNonDecreasingArray(int[] arr) {
        int n = arr.length;
        int res = 1;  // The maximum length of the non-decreasing array
        for (int i = 0; i < n - 1; i++) {
            // If the current number and the next number are not decreasing, add them together
            if (arr[i] <= arr[i + 1]) {
                res++;
            } else {
                // Otherwise, set the current number to the next number
                arr[i] = arr[i + 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Test the function
        int[] arr1 = {5, 1, 6, 7, 8, 2};
        System.out.println(maxNonDecreasingArray(arr1));  // Output: 4
    }
}
