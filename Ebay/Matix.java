package Ebay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Matix {
    public static void main(String[] args) {

        int[][] matrix = {{9,7,8,9,2},
                {6,9,9,6,1},
                {4,10,1,3,10},
                {18,2,3,9,3},
                {4,6,8,5,21}};
        int frameSize = 3;
        int answer = findSum(matrix, frameSize);
        System.out.println(answer);
    }

    private static int findSum(int[][] matrix, int frameSize) {

        //find all the sums of the matrix.
        HashMap<Integer, List<List<Integer>>> sumToMatrix = new HashMap<>();

        int maxSum = Integer.MIN_VALUE;
        int numMovesDown = matrix.length - frameSize;
        int numMovesRight = matrix[0].length - frameSize;

        int upDown = 0;
        int leftRight;

        //all squares of size 3
        while (upDown <= numMovesDown) {

            leftRight = 0;

            while (leftRight <= numMovesRight) {
                //make a new square
                int[][] square = new int[frameSize][frameSize];
                for (int i = upDown; i < frameSize + upDown; i++) {
                    for (int j = leftRight; j < frameSize + leftRight; j++) {
                        //make a new matrix
                        int x = i - upDown;
                        int y = j - leftRight;
                        square[x][y] = matrix[i][j];
                    }
                }

                //find the sum of that square
                int sum = sumOfSquare(square);
                //update max sum
                maxSum = Math.max(maxSum, sum);
                //put the value in our hashmap
                addToHashMap(sumToMatrix, sum, square);

                leftRight++;
            }

            upDown++;
        }

        //corner frames
        //top left
        //make a new square
        int[][] square = new int[frameSize][frameSize];
        for (int i = 0; i < frameSize; i++) {
            for (int j = 0; j < frameSize; j++) {
                //make a new matrix
                int x = i;
                int y = j;
                square[x][y] = matrix[i][j];
            }
        }

        //find the sum of that square
        int sum = sumOfSquare(square);
        //update max sum
        maxSum = Math.max(maxSum, sum);
        //put the value in our hashmap
        addToHashMap(sumToMatrix, sum, square);
        //top right
        //bottom left
        //bottom right


        //get the list of the lists of all our max values
        List<List<Integer>> master = sumToMatrix.get(maxSum);
        //set for all our values
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < master.size(); i++) {
            for (int j = 0; j < master.get(i).size(); j++) {
                set.add(master.get(i).get(j));
            }
        }

        //add all the values of our set
        int total = 0;
        for (Integer n : set) {
            total = total + n;
        }


        return total;

    }

    private static void addToHashMap(HashMap<Integer, List<List<Integer>>> sumToMatrix, int sum, int[][] square) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                list.add(square[i][j]);
            }
        }

        if (sumToMatrix.containsKey(sum)) {
            List<List<Integer>> masterList = sumToMatrix.get(sum);
            masterList.add(list);
            sumToMatrix.put(sum, masterList);
        } else {
            List<List<Integer>> masterList = new ArrayList<>();
            masterList.add(list);
            sumToMatrix.put(sum, masterList);
        }
    }

    private static int sumOfSquare(int[][] square) {
        int sum = 0;

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                sum = sum + square[i][j];
            }
        }
        return sum;
    }
}
