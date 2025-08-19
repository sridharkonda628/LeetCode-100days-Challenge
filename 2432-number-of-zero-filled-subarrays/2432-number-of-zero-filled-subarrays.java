class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;

        long cnt =0;
        long ans =0;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                cnt++;
            }else{
                ans+=(cnt*(cnt+1)/2);
                cnt =0;
            }
        }
        ans+=(cnt*(cnt+1)/2);

        return ans;
    }
}