class Solution {
    public int nextBeautifulNumber(int n) {
        // List<Integer> possiblePerm = new ArrayList<>();
        for(int nextBeautifulNumber=n+1;nextBeautifulNumber<=1224444;nextBeautifulNumber++){
            if(isBalanced(nextBeautifulNumber)){
                return nextBeautifulNumber;
            }
        }
        return -1;
    }
    public static boolean isBalanced(int num ){
        int []cntArr = new int[10];

        while(num!=0){
            cntArr[num%10]++;
            num=(num/10);
        }

        for(int digits =0;digits<10;digits++){
            if(cntArr[digits]>0 && cntArr[digits]!=digits){
                return false;
            }
        }

        return true;


    }
}