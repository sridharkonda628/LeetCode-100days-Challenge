class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int num =0;
        for(String word : operations){
            char ch = word.charAt(0);
            char ch2  = word.charAt(2);
            if(ch=='X'){
                if(ch2 =='+'){
                    num++;
                }else{
                    num--;
                }
            }else{
                if(ch=='+'){
                    ++num;
                }else{
                    --num;
                }
            }
        }

        return num;
    }
}