class Solution {
    int mod = (int)1e9+7;
    public int[] productQueries(int n, int[][] queries) {
    int[] pow = new int[31];
    // pow[0] = 1;
    // int stI =0;
    // int flg =0;
    for(int i=0;i<30;i++){
        if(checkBit(i,n)){
            pow[i] = (1<<i);
            // if(flg ==0) {
            //     stI = i;
            //     flg =1;
            // }
        }
        // pow[i] = pow[i-1]*2;
    }
    List<Integer> compPow= new ArrayList<>();
    for(int num: pow){
        if(num!=0){
            compPow.add(num);
        }
    }

        int len = queries.length;

        int []res = new int[len];
        int idx =0;
        for(int[] que: queries){
            int st = que[0];
            int end = que[1];
            long tp =1;
            for(int i=st;i<=end;i++){
                tp=(tp%mod*compPow.get(i)%mod)%mod;
            }
            res[idx++] = (int)tp;
        }

        return res;

    }
    public static boolean checkBit(int i,int n){
        return ((n&(1<<i))!=0);
    }
}