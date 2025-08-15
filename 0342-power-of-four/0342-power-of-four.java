class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        if(n==1  ) return true;

        int lo = 0;
        int hi = 20;
        
        
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            long tp = (long)Math.pow(4,mid);

            if(tp==n){
                return true;
            }else if(tp>n){
                hi = mid-1;
            }else{
                lo=mid+1;
            }

        }
        return false;


    }
}