class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int ans =0;
        Arrays.sort(nums);

        for(int side1=0;side1<n-2;side1++){
            int side3 = side1+2;
            for(int side2=side1+1;side2<n-1 && nums[side1]!=0;side2++){

                while(side3<n && nums[side1]+nums[side2]>nums[side3] ){
                    side3++;
                }
                ans+=(side3-side2-1);

            }
        }

        return ans;
    }
}