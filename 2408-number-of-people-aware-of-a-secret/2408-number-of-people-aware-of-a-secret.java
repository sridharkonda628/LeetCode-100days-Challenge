class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        
        long share = 0, MOD = (long)1e9 + 7;
        //
        for (int t1 = 2; t1 <= n; t1++) {
            
            if (t1-delay > 0)
                share = (share + dp[t1 - delay] + MOD) % MOD;
                //
            if (t1 - forget > 0)
                share = (share - dp[t1 - forget] + MOD) % MOD;
dp[t1] = share;
        }

        long peopleAwareOfSecret = 0;
        
        for (int i = n - forget + 1; i <= n; i++)
            peopleAwareOfSecret = (peopleAwareOfSecret + dp[i]) % MOD;
        
        return (int)peopleAwareOfSecret;
    }
}