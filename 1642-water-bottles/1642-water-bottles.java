class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans =0;
        int extra =0;

        while(numBottles!=0){
            int empty = (numBottles);//15,3,1
            ans+= (numBottles);//15+3+1
            numBottles = (numBottles+extra)/numExchange;//3,1
            extra = (empty+extra)%numExchange;//3,3,1
            System.out.println("ans : "+ans+" Empty: "+ empty );
            // numBottles = numBottles/numExchange + numBottles%numExchange;
            System.out.println("newNumBottles "+numBottles);
        }

        return ans;
    }
}