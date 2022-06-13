package Graph;

public class Graph_Medium_130_SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'}
                        ,{'X','O','O','X'}
                        ,{'X','X','O','X'}
                        ,{'X','O','X','X'}};

        board = solve(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static char[][] solve(char[][] board) {

        //idea
        //find all the sections with 'O' that touch edges
        //mark those sections with 'T'
        //scroll through the grid and mark all O's with an X
        //scroll through the grid and mark all T's with an O

        int rows = board.length;
        int lastRow = rows - 1;
        int cols = board[0].length;
        int lastCol = cols - 1;

        for(int c = 0; c < cols; c++) {
            //top row
            dfs(0, c, board, lastRow, lastCol);
            //bottom row
            dfs(lastRow, c, board, lastRow, lastCol);
        }
        for (int r = 0; r < rows; r++)  {
            //left side
            dfs(r, 0, board, lastRow, lastCol);
            //right side
            dfs(r, lastCol, board, lastRow, lastCol);
        }

        //scroll through the board marking all O's X's and all T's O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }

        return board;
    }

    private static void dfs(int r, int c, char[][] board, int lastRow, int lastCol) {

        if (r < 0 || r > lastRow || c < 0 || c > lastCol) {
            return;
        }
        if (board[r][c] == 'O') {
            board[r][c] = 'T';
            //up
            dfs(r - 1, c, board, lastRow, lastCol);
            //down
            dfs(r + 1, c, board, lastRow, lastCol);
            //right
            dfs(r, c + 1, board, lastRow, lastCol);
            //left
            dfs(r, c - 1, board, lastRow, lastCol);

        }
    }
}
