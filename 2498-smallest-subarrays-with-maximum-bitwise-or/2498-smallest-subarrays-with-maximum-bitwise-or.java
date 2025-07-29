class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int maxOr= 0;

        int n = nums.length;
        int[] bitsPos = new int[31];

        Arrays.fill(bitsPos,-1);
        int[] smallestSubarraysAns = new int[n];

        

        for(int i=n-1;i>=0;i-- ){
            int j =i;
            for(int k=0;k<31;++k){
                if((nums[i]&(1<<k))==0){
                    if(bitsPos[k]!=-1){
                        j = Math.max(j,bitsPos[k]);
                    }
                }else{
                    bitsPos[k] = i;

                }
            }
            smallestSubarraysAns[i]  = j-i+1;
        }
        return smallestSubarraysAns;
    }
}