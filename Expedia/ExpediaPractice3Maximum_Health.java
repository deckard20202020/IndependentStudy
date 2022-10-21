package Expedia;

import java.util.*;

public class ExpediaPractice3Maximum_Health {
    public static void main(String[] args) {

        int[] initial_players = {1,2};
        int[] new_players = {3,4};
        int rank = 2;

        int answer = getMinimumHealth(initial_players, new_players, rank);
        System.out.println(answer);
    }

    private static int getMinimumHealth(int[] initial_players, int[] new_players, int rank) {

        int answer = 0;

        List<Integer> overflow = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : initial_players) {
            pq.add(p);
        }

        //find the kth player by popping the queue and adding them to our overflow
        for (int j = 0; j < rank - 1; j++) {
            overflow.add(pq.poll());
        }

        //add the top value of the pq to our sum
        answer += pq.peek();

        //put all the players back into the pq
        for (int n : overflow) {
            pq.add(n);
        }

        //clear the overflow
        overflow.clear();

        for (int i = 0; i < new_players.length; i++) {

            //add the new player to the queue
            pq.add(new_players[i]);

            //find the kth player by popping the queue and adding them to our overflow
            for (int j = 0; j < rank - 1; j++) {
                overflow.add(pq.poll());
            }

            //add the top value of the pq to our sum
            answer += pq.peek();

            //put all the players back into the pq
            for (int n : overflow) {
                pq.add(n);
            }

            //clear the overflow
            overflow.clear();
        }


        return answer;
    }
}
