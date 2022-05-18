package TwoPointers;

import java.util.*;

public class TwoPointers_Medium_15_3Sum {
    public static void main(String[] args) {
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {1,2,-2,-1};
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

        //idea
        //put all values in a hash set
        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i] , i);
        }

        Arrays.sort(nums);

        //scroll through array and add up two numbers, removing those two numbers from set
        for (int j = 0; j < nums.length - 2; j++) {
            for (int k = j+1; k < nums.length - 1; k++ ) {
                //find the sum of the two numbers
                int temp = nums[j] + nums[k];

                //see if the opposite of that number is in the set
                if (set.containsKey(-temp) && set.get(-temp) != j && set.get(-temp) != k) {
                    //add them to our list
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[j]);
                    l.add(nums[k]);
                    l.add(-temp);
                    answer.add(l);
                    set.remove(nums[j]);
                    set.remove(nums[k]);
                    set.remove(-temp);
                }

            }
        }

        return answer;
    }
}
