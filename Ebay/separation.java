package Ebay;

import java.util.HashMap;
import java.util.HashSet;

public class separation {
    public static void main (String[] args) {

        int[] numbers = {1,5,4,10,9};
        int separation = 3;
        int answer = findMin(numbers, separation);
        System.out.println(answer);
    }

    private static int findMin(int[] numbers, int separation) {

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - separation; i++) {
            int diff = Math.abs(numbers[i] - numbers[i + separation]);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;

//        HashMap<Integer,Integer> map = new HashMap<>();
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int n : numbers) {
//            set.add(n);
//            map.put(n, map.getOrDefault(n,0)+1);
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < numbers.length; i++) {
//            int num = numbers[i];
//            int count = map.get(num);
//            if (count > 0) {
//                map.put(num, count -1);
//            }
//        }

        //n^2

//        int answer = Integer.MAX_VALUE;
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + separation; j < numbers.length; j++) {
//                int diff = Math.abs(numbers[i] - numbers[j]);
//                answer = Math.min(answer, diff);
//            }
//        }
//
//        return answer;
    }

}
