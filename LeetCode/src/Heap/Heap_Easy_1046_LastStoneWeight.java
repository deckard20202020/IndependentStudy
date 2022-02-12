package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_Easy_1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }

        int answer = -1;

        //put the stones in a MAX heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s: stones) {
            pq.add(s);
        }
        //we will do this while the size of the heap is >1
        while (pq.size() > 1) {
            // pull two stones out
            int a = pq.poll();
            int b = pq.poll();

            //if they are = do nothing

            if (a != b) {
                int n = a-b;
                pq.add(n);
            }

        }

        if (pq.isEmpty()) {
            answer = 0;
        } else {
            answer = pq.poll();
        }

        return answer;
    }
}
