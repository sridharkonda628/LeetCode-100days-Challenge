class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len = spells.length;
        int[] successfulPairs = new int[len];
        Arrays.sort(potions);

        for(int i=0;i<len;i++){
            long mp = spells[i];
            int cnt = BS(potions,mp,success);
            successfulPairs[i] = cnt;
            
        }

        return successfulPairs;
    }

    public static int BS(int[] potions, long mul, long success){
        int lo =0;
        int hi = potions.length-1;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;

            if(mul*potions[mid]>=success){
                hi =mid-1;
            }else{
                lo = mid+1;
            }

        }

        return potions.length-lo;
    }
}