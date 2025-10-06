class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[][] direcsFourWays = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Set<String> hSetToTrackElements = new HashSet<>();
        
        pq.offer(new int[]{grid[0][0], 0, 0});
        
while (!pq.isEmpty()) {
int[] curr = pq.poll();
            int max_d = curr[0], r = curr[1], c = curr[2];
            
            String key = r + "," + c;
            if (hSetToTrackElements.contains(key)) continue;

            hSetToTrackElements.add(key);
            
            if (r == m-1 && c == n-1) return max_d;
            
            for (int[] dir : direcsFourWays) {
                int nRow = r + dir[0], nCol = c + dir[1];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && !hSetToTrackElements.contains(nRow + "," + nCol)) {
                    int new_d = Math.max(max_d, grid[nRow][nCol]);
                    pq.offer(new int[]{new_d, nRow, nCol});
                }
            }
        }
        return -1;
    }
}