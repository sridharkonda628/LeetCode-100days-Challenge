class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<=n-1;i++){
            if(checkValid(i) && checkValid(n-i)){
                return new int[]{i,n-i};
            }   
        }
        return new int[2];
    }

    public static boolean checkValid(int num){
        while(num!=0){
            if(num%10==0){
                return false;
            }
            num = num/10;
        }
        return true;
    }
}