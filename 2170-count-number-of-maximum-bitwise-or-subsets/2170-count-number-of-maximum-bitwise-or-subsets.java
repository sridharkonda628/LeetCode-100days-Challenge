class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        //using Recurion: T.C ==>O(2^n), S.C==> Stack space, Recursive stack calls,can be solved using other metods
         int maxXor = 0;

        for(int num: nums){
            maxXor |= num;
        }

        return cntSubsets(nums, 0,0,maxXor );
    }
    public int cntSubsets(int[] nums, int idx, int curr, int maxi){
        if(idx == nums.length){
            if(curr == maxi){
                return 1;
            }else{
                return 0;
            }
        }

        int cntExcludingCurrIdx = cntSubsets(nums,idx+1,curr,maxi);
        int cntIncludingCurrIdx = cntSubsets(nums,idx+1,curr|nums[idx],maxi);

        return cntExcludingCurrIdx+cntIncludingCurrIdx;
    }
}
