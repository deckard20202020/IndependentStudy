package LeetCodeDaily;

import java.util.HashSet;
import java.util.Set;

public class Easy_1502_CanMakeArithmeticProgressionFromSequence {
    public static void main(String[] arg) {

        int[] arr = {3,5,1};
        boolean answer = canMakeArithmeticProgression(arr);
        System.out.println(answer);
    }

    private static boolean canMakeArithmeticProgression(int[] arr) {

        //idea 1
        //sort the array and find the difference between the first two elements.
        //go through the rest of the array to see if it matches.
        //sorting is nlogn

        //idea 2.
        //go through the array and find the smallest element
        //go throught the array and find the max element
        //put all the elements in a set
        //we know the length of the array so we should be able to tell the difference
        //max - min / num elements -1


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            set.add(arr[i]);

        }

        int length = arr.length;
        if ((max - min) % (length - 1) != 0) {
            return false;
        }

        int diff = (max - min) / (length - 1);

        while (min < max) {
            min = min + diff;
            if (!set.contains(min)) {
                return false;
            }
        }

        return true;
    }
}
