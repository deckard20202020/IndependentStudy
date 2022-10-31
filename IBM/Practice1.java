package IBM;

import java.util.HashMap;

public class Practice1 {
    public static void main (String[] args) {

        int n = 4;
        int[] data = {1, -4, -5, 2};
        int[][] updates = {{2,4}, {1,2}};

        int[] answer = getFinalData(n, data, updates);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] getFinalData(int n, int[] data, int[][] updates) {

        for (int[] arr : updates) {
            int start = arr[0];
            int end = arr[1];
            for (int i = start - 1; i < end; i++) {
                data[i] = -data[i];
            }
        }

        return data;
//        int[] result = new int[data.length];
//
//        //make a hashmap that is 1 indexed
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < data.length; i++) {
//            int key = i + 1;
//            int value = data[i];
//            map.put(key, value);
//        }
//
//        for (int[] arr : updates) {
//            int start = arr[0];
//            int end = arr[1];
//            for (int i = start; i <= end; i++) {
//                int key = i;
//                int value = map.get(key);
//                value = -value;
//                map.put(key, value);
//            }
//        }
//
//        for (Integer key : map.keySet()) {
//            int index = key - 1;
//            int value = map.get(key);
//            result[index] = value;
//        }
//
//        return result;
    }
}
