package LeetCodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Easy_219_ContainsDuplicate2 {
    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int k = 3;

        boolean answer = containsNearbyDuplicate(nums, k);
        System.out.println(answer);

    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {

        //this is probably not the fastest way to do it
        //value = int key = position
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                for (int n : list) {
                    if (Math.abs(n - i) <= k) {
                        return true;
                    }
                }
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        return false;
    }
}
