class Solution {

    private int minimumSum2(int[][] mat, int u, int d, int l, int r) {
        int mini_rw = mat.length;
        int max_rw = 0;
        int miniCol = mat[0].length;
        int maxiCol = 0;
        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (mat[i][j] == 1) {
                    mini_rw = Math.min(mini_rw, i);
                    miniCol = Math.min(miniCol, j);
                    max_rw = Math.max(max_rw, i);
                    maxiCol = Math.max(maxiCol, j);
                }
            }
        }
        return mini_rw <= max_rw
            ? (max_rw - mini_rw + 1) * (maxiCol - miniCol + 1)
            : Integer.MAX_VALUE / 3;
    }

    private int[][] rotateMatrix(int[][] arrArr) {
        int n = arrArr.length;
        int m = arrArr[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[m - j - 1][i] = arrArr[i][j];
            }
        }
        return ret;
    }

    private int helperFn(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int res = n * m;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j + 1 < m; j++) {
                res = Math.min(
                    res,
                    minimumSum2(mat, 0, i, 0, m - 1) +
                    minimumSum2(mat, i + 1, n - 1, 0, j) +
                    minimumSum2(mat, i + 1, n - 1, j + 1, m - 1)
                );
                res = Math.min(
                    res,
                    minimumSum2(mat, 0, i, 0, j) +
                    minimumSum2(mat, 0, i, j + 1, m - 1) +
                    minimumSum2(mat, i + 1, n - 1, 0, m - 1)
                );
            }
        }
        for (int i = 0; i + 2 < n; i++) {
            for (int j = i + 1; j + 1 < n; j++) {
                res = Math.min(
                    res,
                    minimumSum2(mat, 0, i, 0, m - 1) +
                    minimumSum2(mat, i + 1, j, 0, m - 1) +
                    minimumSum2(mat, j + 1, n - 1, 0, m - 1)
                );
            }
        }
        return res;
    }

    public int minimumSum(int[][] mat) {
        int[][] rmat = rotateMatrix(mat);
        return Math.min(helperFn(mat), helperFn(rmat));
    }
}