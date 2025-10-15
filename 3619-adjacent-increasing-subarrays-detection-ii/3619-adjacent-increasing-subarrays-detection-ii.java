class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int len = nums.size();

        if(len ==0) return 0;

        if(len ==1){
            return 1;
        }

        int[] startIdxes = new int[len];
        int[] endIndices = new int[len];

        Arrays.fill(startIdxes,1);
        Arrays.fill(endIndices,1);

        for(int i=1;i<len;i++){
            if(nums.get(i)>nums.get(i-1)){
                endIndices[i]  = endIndices[i-1]+1;
            }
        }
        for(int i=len-2;i>=0;i--){
            if(nums.get(i+1)>nums.get(i)){
                startIdxes[i]  = startIdxes[i+1]+1;
            }
        }

        int maxIncreasingSubarrays =1;

        for(int k=0;k<len-1;k++){
            maxIncreasingSubarrays = Math.max(maxIncreasingSubarrays,Math.min(endIndices[k],startIdxes[k+1]));
        }
        return maxIncreasingSubarrays;

    }
}