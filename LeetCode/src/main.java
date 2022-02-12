import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class main {

    public static void main (String args[]) {
        //int[] array = {4,5,6,7,0,1,2};
        //int[] array = {11,13,15,17};
        //[11,13,15,17]
        //[9,3,2,10]
        int[] array = {9,3,2,10};
        int answer = lastStoneWeight(array);

        System.out.print(answer);




    }

    private static int lastStoneWeight(int[] stones) {

        if (stones.length == 1) {
            return stones[0];
        }

        int answer = -1;

        //put the stones in a MAX heap
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s: stones) {
            pq.add(s);
        }
        //we will do this while the size of the heap is >1
        while (pq.size() > 1) {
            // pull two stones out
            int a = pq.poll();
            int b = pq.poll();

            //if they are = do nothing
            if (a == b) {
                continue;
            } else {
                int n = a-b;
                pq.add(n);
            }

        }

        if (pq.isEmpty()) {
            answer = 0;
        } else {
            while (pq.size() > 1) {
                pq.poll();
            }
            answer = pq.poll();
        }

        return answer;
    }


}

