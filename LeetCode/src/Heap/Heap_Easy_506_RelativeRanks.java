package Heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Heap_Easy_506_RelativeRanks {
    public String[] findRelativeRanks(int[] score) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //put the scores in a heap-nlogn
        for (int s: score) {
            pq.add(s);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        //put the scores in a map with key = array value , value = index in input array-n
        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        //create an array of strings to return
        String[] answer = new String[score.length];
        //should be the same size as the input array

        //pull an element out of the the heap
        int first = pq.poll();
        //find where the value goes
        int location = map.get(first);
        //put gold medal in the array
        answer[location] = "Gold Medal";
        //Check to see if the array is only one element long
        if (score.length == 1) {
            return answer;
        }

        //pull an element out of the heap
        int second = pq.poll();
        //find where the value goes
        location = map.get(second);
        //put silver in the return array
        answer[location] = "Silver Medal";
        //check to see if the array is 2 elements long
        if (score.length == 2) {
            return answer;
        }

        //pull an element out of the heap
        int third = pq.poll();
        //find where the value goes
        location = map.get(third);
        //put bronze in the return array
        answer[location] = "Bronze Medal";
        //check to see if they array is 3 elements long
        if (score.length == 3) {
            return answer;
        }

        //while the heap is not empty
        int i = 4;
        while(!pq.isEmpty()) {
            int place = pq.poll();
            location = map.get(place);
            answer[location] = String.valueOf(i);
            i++;
        }
        //put x in the array
        return answer;

    }
}
