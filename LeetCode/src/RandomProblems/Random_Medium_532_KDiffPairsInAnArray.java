package RandomProblems;

import java.util.HashMap;

public class Random_Medium_532_KDiffPairsInAnArray {
    public static void main(String[] args) {
        int[] nums = {1,3,1,5,4};
        int k = 0;

        int answer = findPairs(nums, k);
    }

    private static int findPairs(int[] nums, int k) {

        //k>0

        //idea
        //put all the elements in a hash map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n,1);
            }
        }

        int count = 0;

        //scoll throught the keyset
        for (Integer i : map.keySet()) {
            //if k>0 //look for the key+n
            if ( k > 0 && map.containsKey(i + k)) {
                count++;
            }

            //if k = 0 //make sure there are at least 2 in the value of the key
            if (k == 0 && map.get(i) >= 2) {
                count++;
            }

        }

        return count;

    }
}
