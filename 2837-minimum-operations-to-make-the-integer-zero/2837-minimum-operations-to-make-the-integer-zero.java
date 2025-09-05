class Solution {

    public int makeTheIntegerZero(int number1, int number2) {
        int cnt = 1;
        while (true) {
            long x = number1 - (long) number2 * cnt;
            //cnt++1
            if (x < cnt) {
                return -1;
            }
            if (cnt >= Long.bitCount(x)) {
                return cnt;
            }
            cnt++;
        }
    }
}