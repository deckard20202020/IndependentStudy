package ArraysAndHashing;

import java.util.HashMap;

public class ArraysAndHashing_Easy_217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        //idea: put all the elements in a hashmap
        //scroll through the keys of the hashmap and see if the vlaue is greater than 1

        //base case
        if (nums.length == 1) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                return true;
            }
        }

        return false;

    }
}
