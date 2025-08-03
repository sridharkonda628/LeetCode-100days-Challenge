class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int p1 = 0;
        int p2 = 0;
        int n = fruits.length;

        int subsetSum = 0;
        int maxTotalFruits = 0;
      
        while (p2 < n) {
            subsetSum += fruits[p2][1];
           
            while (p1 <= p2 && step(fruits, startPos, p1, p2) > k) {
                subsetSum -= fruits[p1][1];
                p1++;
            }
            maxTotalFruits = Math.max(maxTotalFruits, subsetSum);
            p2++;
        }
        return maxTotalFruits;
    }
    public int step(int[][] fruits, int startPos, int p1, int p2) {
        return (Math.min(Math.abs(startPos - fruits[p2][0]),Math.abs(startPos - fruits[p1][0])) +fruits[p2][0] -fruits[p1][0]);
    }
}