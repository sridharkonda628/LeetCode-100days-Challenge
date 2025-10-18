class Solution {

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int maxDistinctElementsCnt = 0;
        //
        int previs = Integer.MIN_VALUE;
        //
        for (int num : nums) {
            int current = Math.min(Math.max(num - k, previs + 1), num + k);
            if (current > previs) {
                maxDistinctElementsCnt++;
                previs = current;
            }
        }
        
        return maxDistinctElementsCnt;
    }
}