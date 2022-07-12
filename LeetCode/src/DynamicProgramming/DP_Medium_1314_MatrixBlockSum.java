package DynamicProgramming;

public class DP_Medium_1314_MatrixBlockSum {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        int[][] answer = matrixBlockSum(mat, k);

    }

    private static int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] rangeSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rangeSum[i + 1][j + 1] = rangeSum[i + 1][j] + rangeSum[i][j + 1] - rangeSum[i][j] + mat[i][j];
            }

        }


        int[][] ans = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m, i + k + 1);
                int c2 = Math.min(n, j + k + 1);
                ans[i][j] = rangeSum[r2][c2] - rangeSum[r2][c1] - rangeSum[r1][c2] + rangeSum[r1][c1];
            }

        }

        return ans;
    }
}
