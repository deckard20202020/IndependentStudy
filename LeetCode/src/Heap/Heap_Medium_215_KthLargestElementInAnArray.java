package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap_Medium_215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {

        //base case check
        if (nums.length == 1) {
            return nums[0];
        }

        int answer = -1;

        //put all the elements in a MAX heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        //pull out the kth element and return it
        for(int i = 0; i <k; i++) {
            answer = pq.poll();
        }

        return answer;
    }
}
