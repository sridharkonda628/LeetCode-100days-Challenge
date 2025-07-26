class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        List<Integer>[] right = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            right[i] = new ArrayList<>();
        }
        for (int[] pairs : conflictingPairs) {
            right[Math.max(pairs[0], pairs[1])].add(Math.min(pairs[0], pairs[1]));
        }

        long result = 0;
        long left[] ={ 0,0};

        long []reward = new long[n+1];

        for(int r=1;r<=n;r++){
            for(int le : right[r]){
                if(le>left[0]){
                    left[1] = left[0];
                    left[0] = le;
                }else if(le>left[1]){
                    left[1] = le;
                }
            }
            result+=r-left[0];

            if(left[0]>0){
                reward[(int)left[0]]+=left[0]-left[1];
            }
        }

        long maxiRew =0 ;
        for(long num : reward){
            maxiRew = Math.max(num,maxiRew);
        }

        return result+maxiRew;

    }
}