package Heap;

import java.util.HashMap;

public class Heap_Medium_347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        //make a hashmap
        //key = num value = #of occurances
        //make a priority queue that will store pairs.
        //scroll through the hashmap and add the pairs to the priority queue
        //pop the priority queue k times and add them to our return array

        int[] answer = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int increment = map.get(nums[i]);
                increment ++;
                map.put(nums[i], increment);
            }

        }

        //how do I scroll through a hashmap???

        //do I need to make a new class pairs???

        //my priority queue should be ordered by the second value of my pairs.

        return answer;
    }
}
