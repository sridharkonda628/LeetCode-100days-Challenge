class Solution {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int maxBottlesDrunk = numBottles;
        for (int emptiedWaterBottles = numBottles; emptiedWaterBottles >= numExchange; numExchange++) {
            maxBottlesDrunk++;
            emptiedWaterBottles -= numExchange - 1;
        }
        return maxBottlesDrunk;
    }
}