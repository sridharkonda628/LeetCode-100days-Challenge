class Solution {
    private int m, n;
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++) dfs(0, j, heights, pacific);
        for (int i = 0; i < m; i++) dfs(i, 0, heights, pacific);
        for (int j = 0; j < n; j++) dfs(m - 1, j, heights, atlantic);
        for (int i = 0; i < m; i++) dfs(i, n - 1, heights, atlantic);

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] vis) {
        if (vis[i][j]) return;
        vis[i][j] = true;
        for (int[] d : dirs) {
            int nRow = i + d[0], nCol = j + d[1];
            if (nRow < 0 || nRow >= m || nCol < 0 || nCol >= n) 
            continue;

            if (heights[nRow][nCol] < heights[i][j]) 
            continue;
            dfs(nRow, nCol, heights, vis);
        }
    }
}