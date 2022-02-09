package Heap;

import java.util.PriorityQueue;

public class Heap_Easy_703_KthLargestElementinaStream {

    public int k;
    public PriorityQueue<Integer> pq;

    public Heap_Easy_703_KthLargestElementinaStream(int k, int[] nums) {
        this.k = k;

        pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.add(num);

        }

        while (pq.size() > k) {
            pq.poll();
        }

    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return pq.peek();

    }
}
