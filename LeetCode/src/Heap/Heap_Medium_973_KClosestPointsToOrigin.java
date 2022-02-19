package Heap;

import java.util.PriorityQueue;

public class Heap_Medium_973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {

        //this is a correct answer but not the fastest
        //this is O(nlogn)
        //could be done in O(n) with
            //Binary Search
            //QuickSelect

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (int i = 0; i < points.length; i++) {
            Pair p = new Pair(points[i][0], points[i][1]);
            pq.add(p);
        }

        int[][] answer = new int[k][2];
        for (int i = 0; i < k; i++) {
            Pair pair = pq.poll();
            int[] p = {pair.x, pair.y};
            answer[i] = p;
        }

        return answer;

    }

    public class Pair implements Comparable<Pair> {
        int x;
        int y;
        double dist;

        public Pair (int x, int y) {
            this.x = x;
            this.y = y;
            dist = Math.pow(x,2) + Math.pow(y,2);
        }

        @Override
        public int compareTo(Pair p) {
            if (this.dist > p.dist) {
                return 1;
            } else if (this.dist < p.dist) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
