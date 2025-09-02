public class Solution {

    public int numberOfPairs(int[][] pts) {
        int numberOfPairAns = 0;
        int n = pts.length;

        for (int i = 0; i < n; i++) {
            int[] ptA = pts[i];
            for (int j = 0; j < n; j++) {
                int[] ptB = pts[j];
                if (i == j || !(ptA[0] <= ptB[0] && ptA[1] >= ptB[1])) {
                    continue;
                }
                if (n == 2) {
                    numberOfPairAns++;
                    continue;
                }

                boolean flgForIllegal = false;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    int[] pointTmp = pts[k];
                    boolean isXContained =
                        pointTmp[0] >= ptA[0] && pointTmp[0] <= ptB[0];
                    boolean isYContained =
                        pointTmp[1] <= ptA[1] && pointTmp[1] >= ptB[1];
                    if (isXContained && isYContained) {
                        flgForIllegal = true;
                        break;
                    }
                }
                if (!flgForIllegal) {
                    numberOfPairAns++;
                }
            }
        }
        return numberOfPairAns;
    }
}