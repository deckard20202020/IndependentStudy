package ZipRecruiter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPeakElements {
    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 3, 1, 3};
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2, 1, 1, 1};
//        int[] nums = {1, 1, 3};
//        int[] nums = null;
//        int[] nums = {1};
//        int[] nums = {1,3};
        int[] answer = findPeakElements(nums);
        for (int n : answer) {
            System.out.print(n + ", ");
        }
    }

    private static int[] findPeakElements(int[] nums) {

        if (nums == null || nums.length < 1) {
            return new int[0];
        }

        if (nums.length == 1) {
            return nums;
        }

        Stack<Integer> stack = new Stack<>();//
        List<Integer> peaks = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {

            if ((!stack.isEmpty() && nums[i] > stack.peek()) || i == 0) {
                if (i == nums.length-1) {
                    peaks.add(nums[i]);
                } else if (i < nums.length-1 && nums[i+1] < nums[i]) {
                    peaks.add(nums[i]);
                } else {
                    stack.push(nums[i]);
                }
            } else {
                stack.push(nums[i]);
            }
        }

//         for (int i = 0; i < peaks.size(); ++i) {
//             System.out.print(peaks.get(i) + ",");
//         }
//         System.out.println();

//         while(!stack.isEmpty()) {
//             System.out.print(stack.pop() + ",");
//         }

        int[] answer = new int[peaks.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = peaks.get(i);
        }
        return answer;
//        return peaks.size() > 0 ? peaks.get(0) : 0;
    }
}
