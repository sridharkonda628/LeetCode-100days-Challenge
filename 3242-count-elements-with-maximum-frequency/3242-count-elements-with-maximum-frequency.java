class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;

        int[] freq =  new int[101];
        int maxiFreq = 0;
        for(int i=0;i<n;i++){
            freq[nums[i]]++;
            maxiFreq = Math.max(maxiFreq,freq[nums[i]]);
        }
        int ans =0;

        for(int i=0;i<=100;i++){
            if(freq[i] == maxiFreq){
                ans++;
            }
        }
        // System.out.print(ans+" "+maxiFreq);
        return ans*maxiFreq;

    }
}