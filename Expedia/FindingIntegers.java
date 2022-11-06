package Expedia;

import java.util.*;

public class FindingIntegers {
    public static void main(String[] args) {
        int[] arr = {4,2,1,3};
        int k = 2;

        int[] answer = getGreatestelements(arr, k);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] getGreatestelements(int[] arr, int k) {

        int[] answer = new int[arr.length - k + 1];

        List<Integer> numsToSave = new ArrayList<>();

        //put the first k items in the list
        for (int i = 0; i < k; i++) {
            numsToSave.add(arr[i]);
        }

        //sort the list
        Collections.sort(numsToSave);
        //add the first value to our answer
        answer[0] = numsToSave.get(0);

        //do the rest
        for (int i = k; i < arr.length; i++) {
            numsToSave.add(arr[i]);
            Collections.sort(numsToSave);
            answer[i - 1] = numsToSave.get(numsToSave.size() - k);
        }

        return answer;
    }
}
