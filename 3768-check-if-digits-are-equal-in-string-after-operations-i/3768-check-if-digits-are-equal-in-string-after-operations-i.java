class Solution {
    
    public boolean hasSameDigits(String s) {
        int n=s.length();
        int [] ans = new int[n];
        
        compressString(s,ans);

        if(ans[0]==ans[1]){
            return true;
        }
        return false;
    }

    public static void compressString(String str,int []ans){
        
        int m= str.length();
        char[] ch = str.toCharArray(); 
        for(int i=0;i<m;i++){
            int p = Character.getNumericValue(str.charAt(i));
            ans[i]=p;     
        }

        while(m-->2){
            for(int i=0;i<m;i++){
                int p = ans[i];
                int q= ans[i+1];
                int mod= (p+q)%10;
                ans[i]=mod;
                System.out.println(ans[i]+" ");
            }
        }
      
        
    }
}