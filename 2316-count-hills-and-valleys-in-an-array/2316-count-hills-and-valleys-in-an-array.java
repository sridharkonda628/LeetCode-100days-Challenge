class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int left = nums[0];
        int countHillValley =0;

        for(int i=1;i<n-1;i++){
            if(nums[i] ==nums[i+1]){
                continue;
            }
            if(nums[i]>left && nums[i]>nums[i+1] || nums[i]<left && nums[i]<nums[i+1]){
                countHillValley++;
            }
            left = nums[i];
        }

        return countHillValley;
    }
}