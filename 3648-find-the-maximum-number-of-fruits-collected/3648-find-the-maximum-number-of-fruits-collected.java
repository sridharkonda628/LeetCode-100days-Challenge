class Solution {
    public int maxCollectedFruits(int[][] RoomsWithFruits) {
        int maxCollectedFruits =0;
        int n = RoomsWithFruits.length;

        for(int i=0;i<n;i++){
            maxCollectedFruits+=RoomsWithFruits[i][i];
        }
        for(int flg =0;flg<2;flg++){
            if(flg ==1){
                for(int i=0;i<n;i++){
                    for(int j=i+1;j<n;j++){
                        int tep = RoomsWithFruits[i][j];
                        RoomsWithFruits[i][j] = RoomsWithFruits[j][i];
                        RoomsWithFruits[j][i] = tep;
                    }
                }
            }

            int[] prevRow = new int[n], currRow = new int[n];

            Arrays.fill(prevRow,-1);
            prevRow[n-1] = RoomsWithFruits[0][n-1];
            for(int row =1;row<n-1;row++){
                Arrays.fill(currRow,-1);
                for(int i=0;i<n;i++){
                    if(prevRow[i] <0) continue;
                    if(i>0) currRow[i-1] = Math.max(currRow[i-1],prevRow[i]+RoomsWithFruits[row][i-1]);
                    if(i<n-1) currRow[i+1] = Math.max(currRow[i+1],prevRow[i]+RoomsWithFruits[row][i+1]);

               
                    currRow[i] = Math.max(currRow[i],prevRow[i]+ RoomsWithFruits[row][i] );

                }
                int[] tp = prevRow;
                prevRow = currRow;
                currRow = tp;
            }
            maxCollectedFruits+=prevRow[n-1];
        }
        return maxCollectedFruits;
    }
}