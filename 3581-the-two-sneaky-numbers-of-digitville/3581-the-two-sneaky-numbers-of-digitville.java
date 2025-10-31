class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] fq = new int[101];
        int[] Thieves = new int[2];
        int ptr =0 ;
        for(int num : nums){
            if(fq[num]==0){
                fq[num]++;
            }else{
                Thieves[ptr]=num;
                ptr++;

            }
        }

        return Thieves;
    }
}