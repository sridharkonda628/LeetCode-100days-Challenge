class Solution {
    public int minScoreTriangulation(int[] values) {
        int len = values.length;
        int[][] minScoreTriangulationDP = new int[len][len];

        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 1; j < len; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    minScoreTriangulationDP[i][j] = Math.min(minScoreTriangulationDP[i][j] == 0 ? Integer.MAX_VALUE : minScoreTriangulationDP[i][j],
                        minScoreTriangulationDP[i][k] + values[i] * values[k] * values[j] + minScoreTriangulationDP[k][j]);
                }
            }
        }

        return minScoreTriangulationDP[0][len - 1];
    }
}