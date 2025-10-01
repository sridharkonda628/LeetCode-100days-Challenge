class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int numWaterBottles =0;
        int extra =0;

        while(numBottles!=0){
            int empty = (numBottles);//15,3,1
            numWaterBottles+= (numBottles);//15+3+1
            numBottles = (numBottles+extra)/numExchange;//3,1
            extra = (empty+extra)%numExchange;//3,3,1
            System.out.println("numWaterBottles : "+numWaterBottles+" Empty: "+ empty );
           
            System.out.println("newNumBottles "+numBottles);
        }

        return numWaterBottles;
    }
}