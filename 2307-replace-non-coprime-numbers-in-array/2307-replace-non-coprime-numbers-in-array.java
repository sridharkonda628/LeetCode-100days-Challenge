class Solution {

    public static int findGCD(int a, int b){
        if(b==0){
            return a;
        }

        return findGCD(b,a%b);
    }

    public static int LCM(int a, int b ){
        // if(a==0 || b==0) return 0;

        return ((a/findGCD(a,b))*b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();

        for(int num : nums){
            int curr = num;

            while(!st.isEmpty() && findGCD(st.peek(),curr)>1){
                int top  = st.pop();
                curr  = LCM(top,curr);
            }
            st.push(curr);
        }
        return new ArrayList<>(st);


    }
}