class Solution {
    static final int MOD = (int)1e9+7, MAX = 31;
    static final long[] factorial = new long[MAX], INV_factorial = new long[MAX];

    static {
        factorial[0] = 1;
        for (int i = 1; i < MAX; i++) factorial[i] = factorial[i - 1] * i % MOD;
        INV_factorial[MAX - 1] = pow(factorial[MAX - 1], MOD - 2);
        for (int i = MAX - 1; i > 0; i--) INV_factorial[i - 1] = INV_factorial[i] * i % MOD;
    }

    static long pow(long x, int n) {
        long ansr = 1;
        for (; n > 0; n >>= 1, x = x * x % MOD)
            if ((n & 1) == 1) ansr = ansr * x % MOD;
        return ansr;
    }

    public int magicalSum(int m, int k, int[] arr) {
        int n = arr.length;
        int[][] pows = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            pows[i][0] = 1;
            for (int j = 1; j <= m; j++)
                pows[i][j] = (int) ((long) pows[i][j - 1] * arr[i] % MOD);
        }

        int[][][][] memo = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : memo)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        return (int) (dfs(0, m, 0, k, pows, memo) * factorial[m] % MOD);
    }

    long dfs(int i, int mLeft, int carry, int kLeft, int[][] pows, int[][][][] memo) {
        int ones = Integer.bitCount(carry);
        if (ones + mLeft < kLeft) return 0; // 
        if (i == pows.length) return (mLeft == 0 && ones == kLeft) ? 1 : 0; // base case check
        if (memo[i][mLeft][carry][kLeft] != -1) return memo[i][mLeft][carry][kLeft]; // memo use 

        long ansr = 0;
        for (int j = 0; j <= mLeft; j++) {
            int bit = (carry + j) & 1; 
            if (bit <= kLeft) { // agar bit useful hai
                long r = dfs(i + 1, mLeft - j, (carry + j) >> 1, kLeft - bit, pows, memo);
                ansr = (ansr + r * pows[i][j] % MOD * INV_factorial[j]) % MOD; // ansrult add 
            }
        }
        return memo[i][mLeft][carry][kLeft] = (int) ansr;
    }
}