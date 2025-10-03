import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;

        if (m < 3 || n < 3)
            return 0;

        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a,b) -> a[0] - b[0] );

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            pQueue.offer(new int[] { heightMap[i][0], i, 0 });

            pQueue.offer(new int[] { heightMap[i][n - 1], i, n - 1 });
            vis[i][0] = vis[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {

            pQueue.offer(new int[] { heightMap[0][j], 0, j });
            pQueue.offer(new int[] { heightMap[m - 1][j], m - 1, j });
            vis[0][j] = vis[m - 1][j] = true;
        }

        int volOfWater = 0;
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!pQueue.isEmpty()) {
            int[] cell = pQueue.poll();
            int height = cell[0], x = cell[1], y = cell[2];

            for (int[] dir : dirs) {
                int nRow = x + dir[0], nCol = y + dir[1];
                
                if (nRow >= 0 && nCol >= 0 && nRow < m && nCol < n && !vis[nRow][nCol]) {
                    volOfWater += Math.max(0, height - heightMap[nRow][nCol]);
                    pQueue.offer(new int[] { Math.max(height, heightMap[nRow][nCol]), nRow, nCol });
                    vis[nRow][nCol] = true;
                }
            }
        }

        return volOfWater;
    }
}