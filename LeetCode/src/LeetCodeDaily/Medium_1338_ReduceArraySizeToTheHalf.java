package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Medium_1338_ReduceArraySizeToTheHalf {
    public static void main(String[] args) {

//        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        int[] arr = {1, 9};
        int answer = minSetSize(arr);
        System.out.println(answer);
    }

    private static int minSetSize(int[] arr) {

        //I feel like my solution is O(nlogn) but there is a much
        //faster method on Leetcode that is also claimed to be O(nlogn)

        int length = arr.length;

        HashMap<Integer, Integer> valueToCount = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (valueToCount.containsKey(arr[i])) {
                int n = valueToCount.get(arr[i]);
                n++;
                valueToCount.put(arr[i], n);
            } else {
                valueToCount.put(arr[i], 1);
            }

        }

        List<Integer> counts = new ArrayList<>();
        for (Integer key : valueToCount.keySet()) {
            counts.add(valueToCount.get(key));
        }

        //sort the list
        Collections.sort(counts, Collections.reverseOrder());

        int count = 0;
        int index = 0;
        while (count < length / 2) {
            int n = counts.get(index);
            count = count + n;
            index++;
        }

        return index;
    }
}
