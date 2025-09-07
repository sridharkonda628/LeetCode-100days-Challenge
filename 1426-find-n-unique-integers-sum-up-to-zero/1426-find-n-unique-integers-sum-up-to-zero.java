class Solution {
    public int[] sumZero(int n) {
        int[] sumZero = new int[n];
        int tp =n/2;

        if((n&1)==0){
            for(int i=0;i<n-1;i+=2){
                sumZero[i]=tp;
                sumZero[i+1] = -tp;
                tp--;
            }
        }else{
            
            for(int i=1;i<n-1;i+=2){
                sumZero[i] = tp;
                sumZero[i+1] = -tp;
                tp--;
            }
        }

        return sumZero;
    }
}