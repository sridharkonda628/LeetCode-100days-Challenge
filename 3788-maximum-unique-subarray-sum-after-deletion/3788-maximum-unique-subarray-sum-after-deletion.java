class Solution {
    public int maxSum(int[] nums) {
        int ans =0;

        int[]freq = new int[201];
        Arrays.fill(freq,0);
        
        for(int num : nums){
            freq[num+100]+=1;
        }
        for(int i=100;i<201;i++){
            if(freq[i]>0){
                ans+=(i-100);
            }
        }
        if(ans==0){
            for(int i=100;i>=0;i--){
                if(freq[i]>0){
                    return i-100;
                }
            }
        }
        

        return ans;
    }
}