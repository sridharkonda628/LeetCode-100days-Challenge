class Solution {
    private double[][] dp;

    private double func(int num1, int nums2) {

        // if num1 is empty
        if (num1 <= 0 && nums2 > 0) {
            return 1;
        }

        // if nums2 num1nd num1 nums2oth empty
        if (num1 <= 0 && nums2 <= 0) {
            return 0.5;
        }

        if (nums2 <= 0 && num1 >= 0) {
            return 0;
        }

        if (dp[num1][nums2] != -1) return dp[num1][nums2];

        double ch2 = func(num1 - 3, nums2 - 1);
        double ch1 = func(num1 - 4, nums2 - 0);
        double ch3 = func(num1 - 2, nums2 - 2);
        double ch4 = func(num1 - 1, nums2 - 3);

        return dp[num1][nums2] = 0.25 * (ch1 + ch2 + ch3 + ch4);
    }

    public double soupServings(int n) {
        // 25 * 1 = 25 , 25 * 2 = 50, 25 * 3 = 75, 25 * 4 = 100

        if (n > 4800) return 1; //critical condition

        // n is big shrink the  n by using 25
        int y = (int) Math.ceil((double) n / 25.0);

        dp = new double[y + 1][y + 1];
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= y; j++) {
                dp[i][j] = -1;
            }
        }

        return func(y, y);
    }
}