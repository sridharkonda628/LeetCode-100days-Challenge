class Solution {

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int len = nums.size();
        int countConceutive = 1;
        int precountConceutive = 0;
        int hasIncreasingSubarrays = 0;

        for (int i = 1; i < len; ++i) {
            if (nums.get(i) > nums.get(i - 1)) {
                ++countConceutive;
            } else {
                precountConceutive = countConceutive;
                countConceutive = 1;
            }
            hasIncreasingSubarrays = Math.max(hasIncreasingSubarrays, Math.min(precountConceutive, countConceutive));
            hasIncreasingSubarrays = Math.max(hasIncreasingSubarrays, countConceutive / 2);
        }

        return hasIncreasingSubarrays >= k;
    }
}