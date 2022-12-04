package Ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CyclicRotations {
    public static void main(String[] args) {

        //int[] array = {3,2,1};
        //int[] array = {3,2,1,5,4};
        //int[] array = {2,1,8,7,6,5,4,3};
        int[] array = {5,4,1,3};
        int answer = numCycles(array);
        System.out.println(answer);
    }

    private static int numCycles(int[] array) {

        int length = array.length;

        //find the sorted array
        List<Integer> sorted = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            sorted.add(array[i]);
        }
        Collections.sort(sorted, Collections.reverseOrder());

        int count = 0;

        while (count <= length + 1) {
            boolean isSorted = true;
            //check to see if the array is sorted
            for (int i = 0; i < length; i++) {
                if (array[i] != sorted.get(i)) {
                    isSorted = false;
                }
            }

            if (isSorted) {
                return count;
            } else {
                rotate(array, 1, length);
                count++;
            }
        }

        return -1;

    }

    public static void rotate(int[] arr, int rotations, int length) {

        while (rotations > length) {
            rotations = rotations - length;
        }

        int[] temp = new int[length - rotations];

        for (int i = 0; i < length - rotations; i++) {
            temp[i] = arr[i];
        }

        for (int i = length - rotations; i < length; i++) {
            arr[i - length + rotations] = arr[i];
        }

        for (int i = 0; i < length - rotations; i++) {
            arr[i + rotations] = temp[i];
        }
//        int[] temp = new int[rotations];
//
//        for (int i = 0; i < rotations; i++) {
//            temp[i] = arr[i];
//        }
//
//        for (int i = rotations; i < length; i++) {
//            arr[i - rotations] = arr[i];
//        }
//
//        for (int i = 0; i < rotations; i++) {
//            arr[i + length - rotations] = temp[i];
//        }
    }
}
