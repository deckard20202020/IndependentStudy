package BinarySearch;

import java.util.HashSet;

public class BinarySearch_Easy_349_IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {

        //binary search solution
        //sort the longer set?
        //iterate through the shorter set
        //for each element search for it in the second set using binary search
        //time complexity would be O(nlogm+mlogm)


        //can avoid binary search
        //linear time complexity
        //put one array in a hash set
        //if the element is in the set, add it to your result

        //Need to use sets so we don't have repeats
        //put the first array into a set
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i ++) {
            set1.add(nums1[i]);
        }
        //create a result set
        HashSet<Integer> resultSet = new HashSet<Integer>();

        //scroll through the second array
        for (int i = 0; i < nums2.length; i ++) {
            //if the first set contains our number
            if (set1.contains(nums2[i])) {
                //add it to our result set
                resultSet.add(nums2[i]);
            }
        }
        //need to return an array
        int[] result = new int[resultSet.size()];
        //int to keep track of where to put in the result array
        int i = 0;
        //loop through the result set
        for (Integer match:resultSet) {
            //put it in our array
            result[i++] = match;
        }
        return result;
    }

}
