package Paypal;

import java.util.*;

public class ClosestNumbers {
    public static void main(String[] args) {
        int[] numbers = {6,2,4,10};
        int[] answer = closestNumbers(numbers);
        for (int n : answer) {
            System.out.println(n);
        }
    }

    private static int[] closestNumbers(int[] numbers) {

//        List<Pair> list = new ArrayList<>();
//
//        //integers are distinct.
//        //put all the numbers in a set
//        HashSet<Integer> set = new HashSet<>();
//        for (int n : numbers) {
//            set.add(n);
//        }
//
//        //find minimum difference in the array
//        int minDist = findMinDiff(numbers, numbers.length);
//
//        //scroll through the array and see if the diff is in the set
//        for (int i = 0; i < numbers.length; i++) {
//            int diff = Math.abs(numbers[i] + minDist);
//            if (set.contains(diff)) {
//                Pair p = new Pair(numbers[i], diff);
//                list.add(p);
//            }
//        }
//
//        //sort the list
//        Collections.sort(list);
//
//        int[] answer = new int[list.size() * 2];
//        for (int i = 0; i < list.size(); i++) {
//            answer[i * 2] = list.get(i).x;
//            answer[i * 2 + 1] = list.get(i).y;
//        }
//
//        return answer;

        List<Integer> list = new ArrayList<>();

        Arrays.sort(numbers);

        int minDiff = findMinDiff(numbers, numbers.length);

        //scroll through the list
        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = Math.abs(numbers[i] - numbers[i+1]);
            if (diff == minDiff) {
                list.add(numbers[i]);
                list.add(numbers[i+1]);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static int findMinDiff(int[] arr, int n)
    {
        // Sort array in non-decreasing order
        Arrays.sort(arr);

        // Initialize difference as infinite
        int diff = Integer.MAX_VALUE;

        // Find the min diff by comparing adjacent
        // pairs in sorted array
        for (int i = 0; i < n - 1; i++)
            if (arr[i + 1] - arr[i] < diff)
                diff = arr[i + 1] - arr[i];

        // Return min diff
        return diff;
    }

    private static class Pair implements Comparable<Pair> {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x < o.x) {
                return -1;
            }
            if (this.x == o.x) {
                if (this.y < o.y) {
                    return - 1;
                }
                if (this.y == o.y) {
                    return 0;
                }
                return 1;
            }

            return 1;
        }

    }
}
