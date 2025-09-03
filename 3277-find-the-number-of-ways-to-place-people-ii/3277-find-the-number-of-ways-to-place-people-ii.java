public class Solution {

    public int numberOfPairs(int[][] points) {
        int numberOfPairs = 0;
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int i = 0; i < points.length - 1; i++) {
            int[] ptsA = points[i];
            int xMinim = ptsA[0] - 1;
            int xMaxim = Integer.MAX_VALUE;
            int yMinim = Integer.MIN_VALUE;
            int yMaxim = ptsA[1] + 1;

            for (int j = i + 1; j < points.length; j++) {
                int[] pointB = points[j];
                if ( pointB[0] > xMinim && pointB[0] < xMaxim && pointB[1] > yMinim && pointB[1] < yMaxim) {
                    numberOfPairs++;
                    xMinim = pointB[0];
                    yMinim = pointB[1];
                }
            }
        }
        return numberOfPairs;
    }
}