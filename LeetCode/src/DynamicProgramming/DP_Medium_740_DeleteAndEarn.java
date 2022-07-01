package DynamicProgramming;

import java.util.HashMap;
import java.util.Hashtable;

public class DP_Medium_740_DeleteAndEarn {
    public static void main(String[] args) {

        int[]nums = {3,4,2};
        int answer = deleteAndEarn(nums);
        System.out.println(answer);
    }

    private static int deleteAndEarn(int[] nums) {
        //Declare a hash table that maps elements to number of points we could get
        Hashtable<Integer, Integer> points = new Hashtable<>();

        //Declare a hash map used for memoization
        HashMap<Integer, Integer> cache = new HashMap<>();

        //loop through nums to populate points and find maxNumber
        int maxNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNumber) {
                maxNumber = nums[i];
            }
            if (points.keySet().contains(nums[i])) {
                Integer p = points.get(nums[i]);
                p = p + nums[i];
                points.put(nums[i], p);
            } else {
                int p = nums[i];
                points.put(nums[i], p);
            }
        }

        return maxPoints(maxNumber, cache, points);
    }

    private static int maxPoints(int num, HashMap<Integer, Integer> cache, Hashtable<Integer, Integer> points) {
        //base cases
        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return points.getOrDefault(1, 0);
        }

        //check to see if num is already in cache
        if (cache.keySet().contains(num)) {
            return cache.get(num);
        }

        //otherwise we need to do the recurrence relation and store it in our cache
        int answer = Math.max(maxPoints(num - 1, cache, points), maxPoints(num - 2, cache, points) + points.get(num));
        return answer;
    }
}
