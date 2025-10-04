class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int p1 = 0;
        int p2 = n-1;
        int maxArea =0;

        while(p1<p2){
            int len = Math.min(height[p1],height[p2]);
            int breadth = p2-p1; 
            maxArea = Math.max(maxArea,breadth*len);

            if(height[p1]>height[p2]){
                p2--;
            }
            else{
                p1++;
            }

        }

        return maxArea;
    }
}