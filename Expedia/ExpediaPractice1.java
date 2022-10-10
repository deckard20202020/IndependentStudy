package Expedia;

import java.util.*;

public class ExpediaPractice1 {
    public static void main(String[] args) {

        int[] list = {2,3,1,1,1,3,4};
        int n = 2;
        int answer = findAnswer(list, n);
        System.out.println(answer);
    }

    private static int findAnswer(int[] ids, int n) {
        //make a hashmap storing count of each element in list
        //key = list value; value = count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : ids) {
            if (map.containsKey(key)) {
                int count = map.get(key);
                count++;
                map.put(key, count);
            } else {
                map.put(key, 1);
            }
        }

        //make a list of the values in the hashmap
        List<Integer> listOfOccurances = new ArrayList<>();
        for (Integer key: map.keySet()) {
            int number = map.get(key);
            listOfOccurances.add(number);
        }

        //sort the list
        Collections.sort(listOfOccurances);

        //how many we have taken out so far
        int taken = 0;
        //index where we are on the list
        int index = 0;
        while (taken <= n) {
            if (listOfOccurances.get(index) <= n - taken) {
                taken = taken + listOfOccurances.get(index);
                index ++;
            } else {
                break;
//                int number = listOfOccurances.get(index);
//                number--;
//                listOfOccurances.remove(index);
//                listOfOccurances.add(index, number);
//                taken = taken + 1;
            }
        }

        return listOfOccurances.size() - index;

//        //which element to remove
//        int take = 0;
//
//        while (taken < n) {
//            int min = Integer.MAX_VALUE;
//            //find the key with the least amount of value
//            for (Integer key : map.keySet()) {
//                if (min > map.get(key)) {
//                    min = map.get(key);
//                    take = key;
//                }
//            }
//            //remove the one you want to take from the hashmap
//            int remaining = map.get(take);
//            remaining--;
//            if (remaining <= 0) {
//                map.remove(take);
//            } else {
//                int value = map.get(take);
//                value--;
//                map.put(take, value);
//            }
//
//            taken++;
//        }
//
//        return map.keySet().size();
    }
}
