class Solution {
    public int findClosest(int x, int y, int z) {
        if(Math.abs(z-y)<Math.abs(z-x)) return 2;
        if(Math.abs(z-x)<Math.abs(z-y)) return 1;
        return 0;
    }
}