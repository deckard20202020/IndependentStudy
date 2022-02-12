import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class main {

    public static void main (String args[]) {
        //int[] array = {4,5,6,7,0,1,2};
        //int[] array = {11,13,15,17};
        //[11,13,15,17]
        int[] array = {5,4,3,2,1};
        String[]answer = findRelativeRanks(array);

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }




    }

    private static String[] findRelativeRanks(int[] score) {

        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //put the scores in a heap
        for (int s: score) {
            pq.add(s);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        //put the scores in a map with key = array value , value = index in input array
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
        //pull an element out of the heap
        int second = pq.poll();
        //find where the value goes
        location = map.get(second);
        //put silver in the return array
        answer[location] = "Silver Medal";
        //pull an element out of the heap
        int third = pq.poll();
        //find where the value goes
        location = map.get(third);
        //put bronze in the return array
        answer[location] = "Bronze Medal";
        //while the heap is not empty
        while(!pq.isEmpty()) {
            int place = pq.poll();
            location = map.get(place);
            answer[location] = String.valueOf(place);
        }
        //put x in the array
        return answer;
    }


}

