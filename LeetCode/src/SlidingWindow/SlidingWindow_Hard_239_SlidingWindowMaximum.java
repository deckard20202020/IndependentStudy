package SlidingWindow;

import java.util.*;

public class SlidingWindow_Hard_239_SlidingWindowMaximum {
    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
        int[] nums = {7,2,4};
        int k = 2;

        int[] answer = maxSlidingWindow(nums,k);
        for (int n : answer) {
            System.out.print(n + " ");
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {

//        ArrayList<Integer> list = new ArrayList<>();
//        Deque<Integer> dq = new ArrayDeque<>();
//
//        for (int i = 0; i < k; i++) {
//            int n = nums[i];
//            while(!dq.isEmpty() && dq.getLast() < n) {
//                dq.removeLast();
//            }
//            dq.addLast(n);
//        }
//        list.add((dq.getFirst()));
//
//        int l = 1;
//        int r = k;
//
//        while (r < nums.length) {
//            int incElem = nums[r];
//            int outElem = nums[l - 1];
//            while (!dq.isEmpty() && incElem > dq.getLast()) {
//                dq.removeLast();
//            }
//            dq.addLast(incElem);
//
//            if(!dq.isEmpty() && outElem == dq.getFirst()) {
//                dq.removeFirst();
//            }
//
//            list.add(dq.getFirst());
//            l++;
//            r++;
//        }

        ArrayList<Integer> list = new ArrayList<>();
        int l = 0;
        int r = 0;
        Deque<Integer> q = new ArrayDeque<>();

        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r + 1) >= k) {
                list.add((nums[q.getFirst()]));
                l ++;
            }
            r++;
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }





//    private static int[] maxSlidingWindow(int[] nums, int k) {
//
//
//        int len = nums.length;
//
//        List<Integer> list = new ArrayList<>();
//
//        int max = 0;
//
//        for (int i = 0; i < len - k + 1; i++) {
//            int temp = findMax(nums, i, k);
//            list.add(temp);
//        }
//
//        int size = list.size();
//        int[] answer = new int[size];
//        for (int i = 0; i < size; i++) {
//            answer[i] = list.get(i);
//        }
//
//        return answer;
//    }

    private static int findMax(int[] nums, int n, int k) {

        int max = 0;
        for (int i = n; i < n + k; i++) {
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
