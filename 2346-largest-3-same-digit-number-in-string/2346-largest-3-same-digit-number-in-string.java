class Solution {
    public String largestGoodInteger(String num) {
        String ans ="";
        // Map<Integer,Integer> hp = new HashMap<>();

        // int le =0;
        int p1 =0,p2=1,p3=2;
        int n = num.length();
        int repeatingDigit =-1;;
      

        while(p1<n && p2<n && p3<n){
            char ch1 = num.charAt(p1);
            char ch2 = num.charAt(p2);
            char ch3 = num.charAt(p3);

            if(ch1==ch2 && ch2 ==ch3 ){
                int tp = ch1-0;
                // break;
                repeatingDigit= Math.max(repeatingDigit,tp);
            }
            p1++;
            p2++;
            p3++;

        }
        if(repeatingDigit==-1){
            return ans;
        }
        char ch =(char) repeatingDigit;
        ans+=ch;
        ans+=ch;
        ans+=ch;
        return ans;


        
    }
}