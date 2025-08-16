class Solution {
    public int maximum69Number (int num) {
        String str="";

        while(num!=0){
            str+=(num%10);
            num=num/10;
        }

        String ans="";
        int idx =0;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)=='6'){
                idx=i;
                break;
            }
        }
        for(int i=str.length()-1;i>=0;i--){
            if(i==idx){
                ans+='9';
            }else{
                ans+=str.charAt(i);
            }
        }

        return Integer.parseInt(ans);
    }
}