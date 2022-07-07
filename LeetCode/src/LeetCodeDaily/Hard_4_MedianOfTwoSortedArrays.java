package LeetCodeDaily;

import java.util.*;

public class Hard_4_MedianOfTwoSortedArrays {
    public static void main(String[] args) {
//        int[] nums1 = {1,3};
//        int[] nums2 = {2};
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
//        int[] nums1 = {1,1};
//        int[] nums2 = {1,2};
        double answer = findMedianSortedArrays(nums1, nums2);
        System.out.println(answer);
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

//        //idea
//        //put all the elements into a set
//        //put that set into a list
//        //order the list
//        //add up all the elements
//        //if size of set is even
//        //return middle two / 2
//        //if the size of the set is odd
//        //return the middle element
//        //THIS IS WRONG
//            //YOU NEED TO COMBIINE ALL ELEMENTS OF BOTH ARRAYS
//            //EVEN IF THEY ARE DUPLICATES
//
//        Set<Integer> set = new HashSet<Integer>();
//        for (int n : nums1) {
//            set.add(n);
//        }
//        for (int n : nums2) {
//            set.add(n);
//        }
//
//        List<Integer> list = new ArrayList<>();
//        int total = 0;
//        for (int n : set) {
//            list.add(n);
//            total = total + n;
//        }
//
//        Collections.sort(list);
//
//        double answer = 0;
//
//        if (set.size() % 2 == 0) {
//            int median = (list.size() / 2) - 1;
//            double left = list.get(median);
//            double right = list.get(median + 1);
//            answer = (left + right) / 2;
//
//        } else {
//            int median = list.size() / 2;
//            answer = list.get(median);
//
//        }
//
//        return answer;

        //idea2
        //we need to merge the lists into one large list
            //keeping order
            //Just add them all to a list
            //Sort the list
            //if length of list is odd
                //return middle
            //if length of list is even
                //return sum of middle two / 2

        List<Integer> list = new ArrayList<>();
        for(int n : nums1) {
            list.add(n);
        }
        for (int n : nums2) {
            list.add(n);
        }

        Collections.sort(list);

        double answer = 0;

        if (list.size() % 2 == 0) {
            int median = list.size() / 2 - 1;
            double left = list.get(median);
            double right = list.get(median + 1);
            answer = (left + right) / 2;
        } else {
            int median = list.size() / 2;
            answer = list.get(median);
        }

        return answer;
    }
}
