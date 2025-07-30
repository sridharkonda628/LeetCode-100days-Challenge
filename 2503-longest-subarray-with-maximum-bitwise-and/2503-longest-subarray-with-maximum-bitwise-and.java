class Solution {
    public int longestSubarray(int[] nums) {
        int i;
        int maxi = 0;
        for(int num: nums){
            maxi = Math.max(num,maxi);
        }

        int ans=0;
        int c=0;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==maxi)
            {
                c++;
   
                ans=Math.max(ans,c);
                
            }
            else 
            c=0;

        }
        return ans;
    }
}
