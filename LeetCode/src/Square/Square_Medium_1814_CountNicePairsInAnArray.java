package Square;

import java.util.HashMap;
import java.util.Map;

public class Square_Medium_1814_CountNicePairsInAnArray {
    public int countNicePairs(int[] nums) {

        //I fee like I could tally the answer in the one loop instead of having two loops

        //Looking for:
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //is equivalent to looking for:
        //nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])

        long answer = 0;
        //Hashmap to keep track of number of times we see nums[i]-rev(nums[i])
        Map<Integer, Long> count = new HashMap<>();

        for (int num : nums) {
            Integer key = num - rev(num);
            //if the map alredy contains the key, increment the value
            if (count.containsKey(key)) {
                Long v = count.get(key);
                v++;
                count.put(key,v);
                //otherwise put the key in the map with value of 1
            } else {
                count.put(key,1L);
            }
        }

        //Tally up our results
        for (long numTimesOccured : count.values()) {
            //1+2+...+n-1 = n*(n-1)/2
            answer += (numTimesOccured * (numTimesOccured - 1) / 2)%1000000007;
        }

        //convert our answer to an int
        int a = (int) answer%1000000007;

        return  a;

    }

    private static int rev(int n) {
        int r = 0;
        while (n > 0) {
            r = r * 10 + (n % 10);
            n /= 10;
        }
        return r;
    }
}
