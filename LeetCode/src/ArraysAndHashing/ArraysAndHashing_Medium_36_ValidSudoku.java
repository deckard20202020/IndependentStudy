package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArraysAndHashing_Medium_36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        //We have to go through every square of the board so this should be O(n^2)

        //we will make 9 col sets, 9 row sets, 9 box sets
        //we will put these sets in an array to easily access them
        //scroll through the input and enter the values into the sets
        //while we scroll through the input we will check to see if the appropriate sets contains the value
        //if it does return false

        List<HashSet<Integer>> rowSets = new ArrayList<>();
        List<HashSet<Integer>> colSets = new ArrayList<>();
        List<HashSet<Integer>> boxSets = new ArrayList<>();

        //NEED TO INITIALIZE THE SETS IN THE LISTS!!!
        for (int i = 0; i < 9; i++) {
            rowSets.add(new HashSet<>());
            colSets.add(new HashSet<>());
            boxSets.add((new HashSet<>()));
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                Character c = board[row][col];
                String string = c.toString();
                int n = 0;
                if (string.equals(".")) {
                    continue;
                } else {
                    n = Integer.valueOf(string);
                }

                int b = row/3 *3 + col/3;
                if (rowSets.get(row).contains(n) || colSets.get(col).contains(n) || boxSets.get(b).contains(n)) {
                    return false;
                } else {
                    rowSets.get(row).add(n);
                    colSets.get(col).add(n);
                    boxSets.get(b).add(n);
                }
            }
        }

        return true;

    }

}
