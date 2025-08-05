class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int m = fruits.length;
        int n = baskets.length;

        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(fruits[i]<=baskets[j]){
                    baskets[j]=-1;
                    break;
                }
            }
           
        }
        int ans = 0;
        for(int j=0;j<n;j++){
            if(baskets[j]!=-1){
                ans++;       
            }
        }
        return ans;
    }
}