package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_Medium_120_Triangle {
    public static void main(String[] args) {
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(4);
        List<Integer> row3 = new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        triangle.add(row4);
        int answer = minimumTotal(triangle);
        System.out.println(answer);

    }

    private static int minimumTotal(List<List<Integer>> triangle) {

        //base case
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }

        int rows = triangle.size();

        //initialize our answer lists
        List<List<Integer>> sums = new ArrayList<>();
        int seed = triangle.get(0).get(0);
        List<Integer> l = new ArrayList<>();
        l.add(seed);
        sums.add(l);

        for (int r = 1; r < rows; r++) {
            int length = triangle.get(r).size();
            List<Integer> list = new ArrayList<>();
            for (int c = 0; c < length; c++) {
                int left = Integer.MAX_VALUE;
                int prevRowSize = triangle.get(r - 1).size();
                if(c - 1 >= 0){
                    left = triangle.get(r).get(c) + sums.get(r - 1).get(c - 1);
                }

                int right = Integer.MAX_VALUE;
                if (c < prevRowSize) {
                    right = triangle.get(r).get(c) + sums.get(r - 1).get(c);
                }

                int toAdd = Math.min(left, right);
                list.add(toAdd);

            }

            sums.add(list);


        }

        int min = Integer.MAX_VALUE;
        int lengthOfLastList = triangle.get(rows - 1).size();
        for(int i = 0; i < lengthOfLastList; i++) {
            min = Math.min(min, sums.get(rows - 1).get(i));
        }

        return min;
    }
}
