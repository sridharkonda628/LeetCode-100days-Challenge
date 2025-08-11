class Solution {
    int mod = (int)1e9+7;
    public int[] productQueries(int n, int[][] queries) {
        int[] pow = new int[31];
    
        for(int i=0;i<30;i++){
            if(checkBit(i,n)){
                pow[i] = (1<<i);
            
            }
        
        }

        List<Integer> compressedPowerArray= new ArrayList<>();
        for(int num: pow){
            if(num!=0){
                compressedPowerArray.add(num);
            }
        }

        int len = queries.length;

        int []productQueries = new int[len];
        int idx =0;
        for(int[] que: queries){
            int st = que[0];
            int end = que[1];
            long tp =1;
            for(int i=st;i<=end;i++){
                tp=(tp%mod*compressedPowerArray.get(i)%mod)%mod;
            }
            productQueries[idx++] = (int)tp;
        }

        return productQueries;

    }
    public static boolean checkBit(int i,int n){
        return (n&1<<i)!=0;
    }
}