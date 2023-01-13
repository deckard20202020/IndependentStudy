package Barclays;

import java.util.Collections;
import java.util.PriorityQueue;

public class q3 {
    public static void main(String[] args) {
        int[] req = {0, 2, 4, 5};
        int[] dur = {7, 4, 1, 4};
        float answer = waitingTime(req, dur);
        System.out.println(answer);
    }

    private static float waitingTime(int[] req, int[] dur) {
        float answer = 0;
        float currentTime = 0;
        float waitingTime = 0;
        float size = 0;
        // Write your code here

        PriorityQueue<Pair> pq = new PriorityQueue(Collections.reverseOrder());

        //create pairs for jobs and pairs
        for (int i = 0; i < req.length; i++) {
            Pair p = new Pair(req[i], dur[i]);
            pq.add(p);
        }

        size = pq.size();

        //put them in a priority queue

        //while queue is not empty,
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            float rt = p.requestTime;
            float d = p.duration;
            waitingTime = waitingTime + Math.abs(rt - currentTime);
            currentTime = currentTime + d;
        }
        //remove a task
        //update the answer
        //update the current time

        answer = waitingTime / size;

        return answer;
    }


    private static class Pair implements Comparable<q3.Pair> {

        int requestTime;
        int duration;

        Pair(int requestTime, int duration) {
            this.requestTime = requestTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(q3.Pair o) {
            if (this.duration < o.duration) {
                return 1;
            }
            if (this.duration > o.duration) {
                return -1;
            }
            if (this.duration == o.duration && this.requestTime <= o.requestTime) {
                return 1;
            }
//            if (this.requestTime == o.requestTime && this.duration == o.duration) {
//                return 0;
//            }

            return -1;

        }
    }
}
