class Solution {
    int mod= (int)1e9+7;
    public int countTrapezoids(int[][] points) {
        Map<Integer,Integer> yGrp = new HashMap<>();
        for(int []pt :points){
            yGrp.put(pt[1],yGrp.getOrDefault(pt[1],0)+1);
            // yGrp.computeIfAbsent(pt[1],k -> new ArrayList<>()).add(pt[0]);
        }
        List<Long> pairCnt = new ArrayList<>();
        for(int xList: yGrp.values()){
            int n = xList;
            if(n>=2){
                long tp = ((long)n*(n-1))/2;
                pairCnt.add(tp);
            }
        }
        long s1 =0;
        long sqareS1= 0;
        for(long val : pairCnt){
            s1= (s1+val)%mod;
            sqareS1= (sqareS1+(val*val)%mod)%mod;
        }

        long res = ((s1*s1)%mod - sqareS1 + mod)%mod;
        res = (res*modInv(2,mod)%mod)%mod;

        // long res =0;
        // int m1 = pairCnt.size();

        // for(int i=0;i<m1;i++){
        //     for(int j=i+1;j<m1;j++){
        //         res= (res+(pairCnt.get(i)*pairCnt.get(j))%mod)%mod;
        //     }
        // }

        return (int) res;
    }

    public long modInv(long a, int m){
        return powr(a,m-2,m);
        
    }
    public long powr(long bas,int exp,int mods){
        long ans =1;
        bas %=mods;
        while(exp>0){
            if((exp&1)==1)  ans = (ans*bas)%mod;
            bas = (bas*bas)%mod;
            exp>>=1;
        }
        return ans;
    }
}