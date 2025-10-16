class Solution {

    public int findSmallestInteger(int[] nums, int value) {
        int[] arrayDP = new int[value];
        for (int num : nums) {
            int vernUm = ((num % value) + value) % value;
            arrayDP[vernUm]++;
        }
        int maxiExcluded = 0;
        while (arrayDP[maxiExcluded % value] > 0) {
            arrayDP[maxiExcluded % value]--;
            maxiExcluded++;
        }
        return maxiExcluded;
    }
}