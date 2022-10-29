package SIGPractice;

import java.util.Arrays;

public class SIGPractice2 {
    public static void main(String[] args) {
        int[][] board = {{7,9,2,1,5,4,3,8,6},
                        {6,4,3,8,2,7,1,5,9},
                {8,5,1,3,9,6,7,2,4},
                {2,6,5,9,7,3,8,4,1},
                {4,8,9,5,6,1,2,7,3},
                {3,1,7,4,8,2,9,6,5},
                {1,3,6,7,4,8,5,9,2},
                {9,7,4,2,1,5,6,3,8},
                {5,2,8,6,3,9,4,1,7}};

//        int[][] board = {{5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5},
//                {5, 5, 5, 5, 5, 5, 5, 5, 5}};

        boolean answer = isValidSoduku(board);
        System.out.println(answer);
    }

    private static boolean isValidSoduku(int[][] board) {

        //make sure all entries are 1-9
        if (!rangeIsGood(board)) {
            return false;
        }

        //array to store uniqueness of numbers 1 through 9
        //need to make it length 10 to include index of 9
        boolean[] u = new boolean[board.length + 1];

        //check each row to see if each element of each row is unique
        for (int r = 0; r < board.length; r++) {

            //make sure u is filled with all false
            Arrays.fill(u, false);

            //check all the columns in the row
            for (int c = 0; c < board[r].length; c++) {
                int value = board[r][c];
                //if we have already seen this value
                if (u[value]) {
                    return false;
                }
                //update our uniqueness array
                u[value] = true;
            }
        }

        //now check each column
        //similar to above
        for (int c = 0; c < board[0].length; c++) {

            //make sure u is filled with all false
            Arrays.fill(u, false);

            //check all the rows in the column
            for (int r = 0; r < board.length; r++) {
                int value = board[r][c];
                //if we have already seen this value
                if (u[value]) {
                    return false;
                }
                //update our uniqueness array
                u[value] = true;
            }
        }

        //now we need to check each 3 by 3 section
        for (int r = 0; r < board.length - 2; r += 3) {
            for (int c = 0; c < board[r].length; c += 3) {

                //make sure u is filled with all false
                Arrays.fill(u, false);

                //scan the block
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        //row
                        int x = r + i;
                        //column
                        int y = c + j;

                        //value at that location
                        int value = board[x][y];

                        //make sure we haven't seen it
                        if (u[value]) {
                            return false;
                        }
                        //update u
                        u[value] = true;
                    }
                }
            }
        }

        //if we have made it this far
        return true;
    }

    private static boolean rangeIsGood(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 1 || board[i][j] > 9) {
                    return false;
                }
            }
        }

        return true;
    }
}
