package Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Heap_Medium_347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        //This is not the fastest solution, this is the solution I came up with.
        //Need to google this problem and learn the faster algorithm.

        int[] answer = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int increment = map.get(nums[i]);
                increment ++;
                map.put(nums[i], increment);
            }

        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(Integer key: map.keySet()) {
            Pair p = new Pair(key, map.get(key));
            pq.add(p);
        }

        for (int i = 0; i < k; i++){
            Pair p = pq.poll();
            int j = p.a;
            answer[i] = j;
        }

        return answer;
    }

    public class Pair implements Comparable<Pair>{
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo (Pair second) {
            if (this.b > second.b) {
                return 1;
            } if (this.b < second.b) {
                return -1;
            } else return 0;
        }
    }
}
