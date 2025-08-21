class Solution {
    public int numSubmat(int[][] mat) {
        int cols = mat[0].length;
        int[] heig = new int[cols];

        int numSubmatWithAllOnes =0;

        for(int[] rw: mat){
            for(int i=0;i<cols;i++){
                heig[i] = rw[i]==0?0:heig[i]+1;
            }
            Stack<int []> st = new Stack<>();

            st.push(new int[]{-1,0,-1});

            for(int i=0;i<cols;i++){
                int h = heig[i];
                while(st.peek()[2]>=h){
                    st.pop();
                }
                int[]top = st.peek();
                int j= top[0];
                int prev = top[1];

                int curr = prev+(i-j)*h;
                st.push(new int[]{i,curr,h});
                numSubmatWithAllOnes+=curr;



            }



        }
        return numSubmatWithAllOnes;
    }
}