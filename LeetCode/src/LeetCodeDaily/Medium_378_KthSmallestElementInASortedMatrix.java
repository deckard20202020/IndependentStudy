package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medium_378_KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
//        int k = 8;
//        int[][] matrix = {{-5}};
//        int k = 1;
//        int[][] matrix = {{1,2},{1,3}};
//        int k = 2;
        int[][] matrix = {{1,2},{1,3}};
        int k = 2;
        //expected answer = 1;
        int answer = kthSmallest(matrix, k);
        System.out.println(answer);
    }

    private static int kthSmallest(int[][] matrix, int k) {

        //ideas
        //put all the elements in a pq, pop k tims = O(nlogn)
        //put all elements in a list, sort the list, get the kth element (nlogn)
        //how can we do this in O(n) time???

        List<Integer> list = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                list.add(matrix[r][c]);
            }
        }

        Collections.sort(list);
        return list.get(k - 1);

    }
}
