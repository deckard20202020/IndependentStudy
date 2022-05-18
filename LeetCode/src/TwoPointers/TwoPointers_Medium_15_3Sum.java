package TwoPointers;

import java.util.*;

public class TwoPointers_Medium_15_3Sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
//        int[] nums = {1,2,-2,-1};
        List<List<Integer>> answer = threeSum(nums);
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.get(i).size(); j++){
                System.out.print(answer.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        //edge cases
        if (nums.length <= 2) {
            return answer;
        }

        //sort the array
        Arrays.sort(nums);

        //idea
        //scroll through the array
        for (int i = 0; i < nums.length; i++) {
            //make a right pointer and left pointer
            int left = i + 1;
            int right = nums.length -1;

            //solution set should not contain duplicates
            //so skip if left two are duplicate
            //make sure we don't go out of bounds
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            //check to see if the left two plus the right = 0
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    answer.add(list);
                    left++;
                    //avoid duplicates
                    while (left < right && nums[left] == nums[left -1]) {
                        left++;
                    }
                    //< move left pointer to the right
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    //> move the right pointer to the left
                } else {
                    right--;
                }
            }
        }

        return answer;

    }
}
