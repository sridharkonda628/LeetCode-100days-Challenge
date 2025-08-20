class Solution {
    public int countSquares(int[][] matrixBin) {
        if (matrixBin == null || matrixBin.length == 0 || matrixBin[0].length == 0) {
            return 0;
        }

        int rows = matrixBin.length;
        int cols = matrixBin[0].length;
        int countSquaresAns = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //dp
                if (matrixBin[i][j] == 1 && i > 0 && j > 0) {
                    matrixBin[i][j] = Math.min(
                        matrixBin[i - 1][j - 1],
                        Math.min(matrixBin[i - 1][j], matrixBin[i][j - 1])
                    ) + 1;
                }
                countSquaresAns += matrixBin[i][j];
            }
        }

        return countSquaresAns;
    }
}