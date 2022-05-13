import java.util.*;

public class main {

    public static void main (String args[]) {

        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}};

        boolean answer = isValidSudoku(board);
        System.out.println(answer);

        int[] nums = {5, 4, 3, 2, 1};
        Arrays.sort(nums);
        System.out.println(nums[0]);


    }

    public static boolean isValidSudoku(char[][] board) {

        //we will make 9 col sets, 9 row sets, 9 box sets
        //we will put these sets in an array to easily access them
        //scroll through the input and enter the values into the sets
        //while we scroll through the input we will check to see if the appropriate sets contains the value
        //if it does return false

        List<HashSet<Integer>> rowSets = new ArrayList<>();
        List<HashSet<Integer>> colSets = new ArrayList<>();
        List<HashSet<Integer>> boxSets = new ArrayList<>();

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

