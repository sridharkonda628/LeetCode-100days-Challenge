class Solution {
    public int triangularSum(int[] nums) {
        int len = nums.length;

        int triangularSum=0;

        for(int sz=len;sz>0;sz--){
            
            for(int i=0;i<sz-1;i++){
                nums[i] = (nums[i]+nums[i+1])%10;
            }

        }

        triangularSum= nums[0];

        return triangularSum;
    }
}