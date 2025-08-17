class Solution {
    public double new21Game(int N, int K, int maxiPoints) {
        if (K == 0 || N >= K - 1 + maxiPoints) return 1.0;

        double[] dpArray = new double[maxiPoints]; 

        //
        dpArray[0] = 1.0;
        double subAr = 1.0, new21Game = 0.0;

        for (int i = 1; i <= N; i++) {
            double prob = subAr / maxiPoints;
            
            if (i < K) {
                subAr += prob;
            } else {
                new21Game += prob;
            }

            if (i >= maxiPoints) {
                subAr -= dpArray[i % maxiPoints];
            }

            dpArray[i % maxiPoints] = prob;
        }

        return new21Game;
    }
}