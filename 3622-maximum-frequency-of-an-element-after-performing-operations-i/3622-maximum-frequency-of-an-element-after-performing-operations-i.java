class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int len = nums.length;

        if(len ==0) return 0;

        int maxiVal =0;

        for(int num : nums){
            maxiVal = Math.max(maxiVal,num);
        }

        int sz = maxiVal+k+2;

        int[] fq = new int[sz];

        for(int num : nums){
            fq[num]++;
        }

        for(int i=1;i<sz;i++){
            fq[i]+=fq[i-1];
        }

        int ans =0;
        for(int t=0;t<sz;t++){

            int left = Math.max(0,t-k);
            int right = Math.min(sz-1,t+k);
            int totlFqT = fq[right] - (left>0? fq[left-1]:0);

            int freqT = (t>0 )?(fq[t]-fq[t-1]):fq[t];

            int canConvert = totlFqT - freqT;

            int ops = Math.min(numOperations,canConvert);

            ans = Math.max(freqT+ops,ans);



        }

        return ans;


    }
}