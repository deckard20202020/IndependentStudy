package BinarySearch;

public class BinarySearch_Medium_74_Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        //check the last element element of the array
        //if it is less
        //this is the row
        //do a binary search for the element in that row.

        //checks for empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int width = matrix[0].length;
        int height = matrix.length;
        int row = -1;

        //scroll throught the rows to find the row it is in
        for (int i = 0; i < height; i++) {
            if (matrix[i][width - 1] >= target) {
                //we have found the row
                row = i;
                break;
            }
        }

        //quick check to see if the element is not here
        if(row == -1) {
            return false;
        }

        //do a binary search for an element in that row
        int start = 0;
        int end = width - 1;

        while (start <= end) {
            int midpoint = start + (end - start)/2;

            if (matrix[row][midpoint] == target) {
                //we found it
                return true;
            } else if (matrix[row][midpoint] <= target) {
                //go right
                start = midpoint + 1;
            } else {
                //go left
                end = midpoint -1;
            }
        }

        return false;
    }
}
