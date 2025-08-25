// import java.util.*;
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        List<Integer> ans = new ArrayList<>();
        boolean flg = false;

        for(int i=0;i<rows;i++){
            int p1 = i;
            int p2 =0;
            List<Integer> diagRow = new ArrayList<>();

            while(p1>=0 && p2<cols){
                diagRow.add(mat[p1][p2]);
                p1--;
                p2++;
            }
            if(!flg){
                ans.addAll(diagRow);
                flg = true;
            }else{
                Collections.reverse(diagRow);
                ans.addAll(diagRow);
                flg = false;
            }
        }

        for(int i=1;i<cols;i++){
            int p1 = rows-1;
            int p2 =i;
            List<Integer> diagRow = new ArrayList<>();

            while(p1>=0 && p2<cols){
                diagRow.add(mat[p1][p2]);
                p1--;
                p2++;
            }
            if(!flg){
                ans.addAll(diagRow);
                flg = true;
            }else{
                Collections.reverse(diagRow);
                ans.addAll(diagRow);
                flg = false;
            }
        }

        int[] finalAns = new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            finalAns[i] = ans.get(i);
        }

        return finalAns;

    }
}