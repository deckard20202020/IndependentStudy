package IBM;

import java.util.HashMap;

public class HackathonAtHackerRank {
    public static void main(String[] args) {

//        int[] teamSize = {1,2,2,3,4};
//        int[] teamSize = {1,1,1,1,1};
        int[] teamSize = {1,1,1,1,1,2, 2, 2};
//        int [] teamSize = {1};
//        int [] teamSize = {1,2};
        int k = 2;

        int answer = equalizeTeamSize(teamSize, k);
        System.out.println(answer);
    }

    private static int equalizeTeamSize(int[] teamSize, int k) {

        //base case
        if (teamSize.length <= k) {
            return teamSize.length;
        }

        //keeps track of count of most common element in array
        int max = Integer.MIN_VALUE;

        //make a map of all the values and their quantities
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer n : teamSize) {
            if (map.containsKey(n)) {
                int value = map.get(n);
                value++;
                max = Math.max(max, value);
                map.put(n, value);
            } else {
                max = Math.max(max, 1);
                map.put(n, 1);
            }
        }

        int answer = max + k;

        return Math.min(max + k, teamSize.length);
    }
}
