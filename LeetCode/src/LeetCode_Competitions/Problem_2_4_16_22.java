package LeetCode_Competitions;

import java.util.HashMap;

public class Problem_2_4_16_22 {
    public static void main(String[] args) {
//        https://leetcode.com/contest/weekly-contest-289/problems/minimum-rounds-to-complete-all-tasks/
//        6071. Minimum Rounds to Complete All Tasks

        int[] tasks = {2,3,3};

        int answer = minimumRounds(tasks);
        System.out.println(answer);
    }

    private static int minimumRounds(int[] tasks) {


        int answer = 0;

        //idea put all values in a hash map
        //key = difficulty of task value = # of task
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            if (!map.containsKey(tasks[i])) {
                map.put(tasks[i], 1);
            } else {
                int n = map.get(tasks[i]);
                n++;
                map.put(tasks[i], n);
            }
        }

        //go through all the keys and make sure none have only one task
        for(Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return -1;
            }
        }

        //go through all the keys in the hash map and start doing tasks
        for(Integer key : map.keySet()) {
            while (map.get(key) > 0) {
                if (map.get(key) >= 3 && map.get(key) != 4) {
                    int n = map.get(key);
                    n = n-3;
                    map.put(key,n);
                    answer++;
                } else {
                    int n = map.get(key);
                    n = n - 2;
                    map.put(key, n);
                    answer++;

                }
            }
        }



        return answer;

    }
}
