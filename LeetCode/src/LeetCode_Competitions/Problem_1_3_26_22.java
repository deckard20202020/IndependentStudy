package LeetCode_Competitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_1_3_26_22 {
    public static void main (String args[]) {
//        2215. Find the Difference of Two Arrays
//        Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
//
//        answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
//                answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
//                Note that the integers in the lists may be returned in any order.
//        Input: nums1 = [1,2,3], nums2 = [2,4,6]
//        Output: [[1,3],[4,6]]
//        Explanation:
//        For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
//        For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].
//        Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
//        Output: [[3],[]]
//        Explanation:
//        For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
//        Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

//        1 <= nums1.length, nums2.length <= 1000
//        -1000 <= nums1[i], nums2[i] <= 1000
        int[] nums1 = {1,2,3};
        int []nums2 = {2,4,6};

        List<List<Integer>> a =  findDifference(nums1, nums2);

        System.out.print("Test");

    }




    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();


        //edge cases
        if (nums1 == null || nums1.length == 0) {
            for (Integer n : nums2) {
                list2.add(n);
            }
            answer.add(list2);
            answer.add(list1);
            return answer;
        }

        if (nums2 == null || nums2.length == 0) {
            for (Integer n : nums1) {
                list1.add(n);
            }
            answer.add(list2);
            answer.add(list1);
            return answer;
        }

        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();

        for (Integer n : nums1) {
            map1.put(n,1);
        }
        for (Integer n : nums2) {
            map2.put(n,1);
        }

        for (Integer n: nums1){
            if (!map2.containsKey(n) && !list2.contains(n)) {
                list2.add(n);
            }
        }

        for (Integer n: nums2){
            if (!map1.containsKey(n) && !list1.contains(n)) {
                list1.add(n);
            }
        }

        answer.add(list2);
        answer.add(list1);

        return answer;
    }
}
