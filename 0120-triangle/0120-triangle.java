class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n  =triangle.size();
        int[][] dp120 = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                dp120[i][j]= triangle.get(i).get(j);
            }
        }

        for(int i = n-2; i>=0;i--){
            for(int j = 0;j<=i;j++){
                dp120[i][j] += Math.min(dp120[i+1][j],dp120[i+1][j+1]);
            }
        }

        return dp120[0][0];
    }
}