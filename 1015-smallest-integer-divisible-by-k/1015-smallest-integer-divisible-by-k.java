class Solution {
    public int smallestRepunitDivByK(int k) {
       int rem =0;
       for(int ans =1;ans<=k;ans++){
        rem = (rem*10+1)%k;

        if(rem == 0) return ans;
       }

       return -1;
    }
}