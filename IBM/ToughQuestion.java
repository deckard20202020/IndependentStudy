package IBM;

import java.util.Arrays;
import java.util.HashMap;

public class ToughQuestion {
    public static void main(String[] args) {

        int[] arr = {5,1,4,6,10};
        int[] answer = minValues(arr);
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }

    private static int[] minValues(int[] arr) {

        int[] answer = new int[arr.length];
        //key = index, value = value
        HashMap<Integer, Integer> mapIndexToValue = new HashMap<>();
        HashMap<Integer, Integer> mapValueToIndex = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            mapIndexToValue.put(i, arr[i]);
            mapValueToIndex.put(arr[i], i);
        }
//        Arrays.sort(arr);
//
//        //find the number we are looking for
//        for (int i = 0; i < arr.length; i++) {
//            int n = arr[i];
//            //if it's the smallest number we know we can't do anything
//            if ( i == 0) {
//                answer[mapValueToIndex.get(n)] = -1;
//            }
//            //second number
//            if (i == 1) {
//                //is it greater than 0?
//
//            }
//        }

        //make a hashmap of possibilites


        return answer;
    }
}
