class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
       
        double maxDiag =0;
        int maxArea =0;
        for(int i=0;i<n;i++){
            int l = dimensions[i][0];
            int b = dimensions[i][1];
            double diagLen = Math.sqrt(l*l+b*b);
            
            if(diagLen>maxDiag){
                maxDiag = diagLen;
                maxArea = l*b;
            }
            if(diagLen == maxDiag){
                 maxArea = Math.max(maxArea, l*b);
            }
            
        }

        return maxArea;

    }
}