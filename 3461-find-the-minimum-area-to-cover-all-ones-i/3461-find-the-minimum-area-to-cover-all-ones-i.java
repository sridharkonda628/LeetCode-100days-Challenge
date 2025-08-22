class Solution {
    public int minimumArea(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minimumBreadth = rows;
        int maximumBreadth =0;

        int minimumLength = cols;
        int maximumLength = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    minimumBreadth = Math.min(minimumBreadth,i);
                    maximumBreadth = Math.max(maximumBreadth,i);
                    minimumLength = Math.min(minimumLength,j);
                    maximumLength = Math.max(maximumLength,j);
                 }
            }
        }

        return (maximumLength-minimumLength+1)*(maximumBreadth-minimumBreadth+1);
    }
}