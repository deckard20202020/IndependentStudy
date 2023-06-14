package FlexTrade;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(5);
//        arr.add(10);
        int threshold = 10;
        
        int answer = minimumDivisor(arr, threshold);
        System.out.println(answer);
        
    }

    private static int minimumDivisor(List<Integer> arr, int threshold) {
        int left = 1;
        int right = findMax(arr);
//        int right = Integer.MAX_VALUE;  // Assuming a maximum divisor of 10^6

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = calculateSum(arr, mid);

            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int findMax(List<Integer> arr) {
        int max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }

        return max;
    }

    private static int calculateSum(List<Integer> arr, int divisor) {
        int sum = 0;

        for (int num : arr) {
            sum += Math.ceil((double) num / divisor);
        }

        return sum;
    }
}
