class Solution {
    public boolean isSubsequence(String s, String t) {
        int N=s.length();
        int M=t.length();
        
        int p1 =0;
        int p2=0;
        while(p1<N && p2<M){
            if(s.charAt(p1)==t.charAt(p2)){
                p1++;
            }
            p2++;
        }
        System.out.println(p1+" "+p2);

        return (p1==N);
    }
}