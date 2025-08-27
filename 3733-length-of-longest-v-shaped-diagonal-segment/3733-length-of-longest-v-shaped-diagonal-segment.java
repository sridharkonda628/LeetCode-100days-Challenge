class Solution {
    private static final int[][] dirs = {
        {1,1},
        {1,-1},
        {-1,-1},
        {-1,1},
    };

    private int[][][][] memo;

    private int[][] mat;
    private int rw,col;



    public int lenOfVDiagonal(int[][] grid) {
        this.mat = grid;
        this.rw = grid.length;
        this.col = grid[0].length;
        this.memo = new int[rw][col][4][2];

        for(int i=0;i<rw;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<4;k++){
                    Arrays.fill(memo[i][j][k],-1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < rw; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        res = Math.max(res, dfs(i, j, dir, true, 2) + 1);
                    }
                }
            }
        }
        return res;


    }

    private int dfs(int cx, int cy, int direction, boolean turn, int target) {
        int nx = cx + dirs[direction][0];
        int ny = cy + dirs[direction][1];
      
        //check the valid boundaries of the cell
        if (nx < 0 || ny < 0 || nx >= rw || ny >= col || mat[nx][ny] != target) {
            return 0;
        }

        int turnInt = turn ? 1 : 0;
        if (memo[nx][ny][direction][turnInt] != -1) {
            return memo[nx][ny][direction][turnInt];
        }

       
        int maxStep = dfs(nx, ny, direction, turn, 2 - target);
        if (turn) {
          
            maxStep = Math.max(
                maxStep,
                dfs(nx, ny, (direction + 1) % 4, false, 2 - target)
            );
        }
        memo[nx][ny][direction][turnInt] = maxStep + 1;
        return maxStep + 1;
    }

}