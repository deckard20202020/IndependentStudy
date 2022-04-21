package ArraysAndHashing;

import java.util.HashMap;

public class testing {
    public static void main(String[] args) {

        int target = 6;
        int[] nums = {3,2,4};
        
        int[] answer = twoSum(nums,target);
        System.out.println(answer);
    }

    private static int[] twoSum(int[] nums, int target) {
        //idea: put all the values of the array in a hashmap value = value, key = index
        //scroll through the array and see if target-array entry is in hashmap

        int[] array = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i] , i);
        }

        for (int j = 0; j < nums.length; j++) {
            if (map.keySet().contains(target - nums[j]) && map.get(target- nums[j]) != j) {
                array[0] = j;
                array[1] = map.get(target - nums[j]);
                return array;
            }
        }

        return array;
    }
}
