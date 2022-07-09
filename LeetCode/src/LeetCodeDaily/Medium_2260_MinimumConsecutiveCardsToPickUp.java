package LeetCodeDaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Medium_2260_MinimumConsecutiveCardsToPickUp {
    public static void main(String[] args) {
        int[] cards = {3,4,2,3,4,7};
        int answer = minimumCardPickup(cards);
        System.out.println(answer);
    }

    private static int minimumCardPickup(int[] cards) {

        //idea
        //we could store the locations of the cards in a hashmap
        //scroll through the array
        //if the card isn't in there, put the index
        //if the card is in there, put the index and
        //update the min distance between two matching cards

        //This works, but there is a faster way to do this

        int minDist = Integer.MAX_VALUE;

        //base case
        if (cards.length == 1) {
            return -1;
        }

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (!map.containsKey(cards[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(cards[i], list);
            } else {
                List<Integer> list = map.get(cards[i]);
                list.add(i);
                map.put(cards[i], list);
                minDist = updateMinDist(minDist, list);
            }
        }


        if (minDist == Integer.MAX_VALUE) {
            return -1;
        }

        return minDist + 1;
    }

    private static int updateMinDist(int minDist, List<Integer> list) {

        for (int i = 1; i < list.size(); i++) {
            int diff = list.get(i) - list.get(i - 1);
            diff = Math.abs(diff);
            minDist = Math.min(minDist, diff);
        }

        return minDist;
    }
}
