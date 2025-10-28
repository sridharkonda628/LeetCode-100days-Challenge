class Solution {
    public int countValidSelections(int[] nums) {
        int len = nums.length;

        int countValidSelectionsResult = 0;
        int arrSum =0;

        for(int num: nums){
            arrSum+=num;
        }

        int leftSumarr =0;
        int rightSumarr =arrSum;

        for(int i=0;i<len;i++){
            if(nums[i]==0){
                if(leftSumarr-rightSumarr>=0 && leftSumarr-rightSumarr<=1){
                    countValidSelectionsResult++;
                }
                if(rightSumarr-leftSumarr>=0 && rightSumarr-leftSumarr<=1){
                    countValidSelectionsResult++;
                }
            }else{
                leftSumarr+=nums[i];
                rightSumarr-=nums[i];
            }
        }

        return countValidSelectionsResult;

    }
}
