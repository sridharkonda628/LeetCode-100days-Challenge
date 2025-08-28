import java.util.*;
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n=grid[0].length;
        
        Map<Integer,PriorityQueue<Integer>> dg= new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val =i-j;
                dg.putIfAbsent(val, new PriorityQueue<>(
                    val>=0 ? Collections.reverseOrder() : Comparator.naturalOrder()
                ));
                dg.get(val).add(grid[i][j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j]= dg.get(i-j).poll();
            }
        }
        return grid;
        
    }
}