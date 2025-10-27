class Solution {
    public int numberOfBeams(String[] bank) {
        int len = bank.length;

        int ans =0;
        List<Integer> safeBoxes = new ArrayList<>();

        for(int i =0;i<len ;i++){
            int num = cntSafeBoxes(bank[i]);
            if(num!=0){

                safeBoxes.add(num);
            }
            // int num2 = cntSafeBoxes(bank[i+1]);

            // System.out.println(num+" HI "+num2);
            // System.out.println(ans);
            // ans+=(num*num2);
        }
        if(safeBoxes.size()>=2){
            for(int i =0;i<safeBoxes.size()-1;i++){
                ans+=(safeBoxes.get(i) * safeBoxes.get(i+1));
            }
        }

        return ans;
    }
    public int cntSafeBoxes(String str){
        int cnt =0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1'){
                cnt++;
            }
        }
        return cnt;
    }
}