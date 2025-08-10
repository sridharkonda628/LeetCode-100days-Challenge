class Solution {
    private int[] findFrequencyOfNum(int n){
        int[] freq = new int[10];
        while(n>0){
            freq[n%10] ++;
            n/=10;
        }
        return freq;
    }
    private boolean checkEqualFreq(int []a, int[] b){
        for(int i=0;i<10;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    public boolean reorderedPowerOf2(int n) {
        int[] freqOfGivenNum = findFrequencyOfNum(n);

        for(int i= 0;i<=30;i++){
            int pow2 = (int) Math.pow(2,i);
            if(checkEqualFreq(freqOfGivenNum,findFrequencyOfNum(pow2))){
                return true;
            }
        }

        return false;
    }
}