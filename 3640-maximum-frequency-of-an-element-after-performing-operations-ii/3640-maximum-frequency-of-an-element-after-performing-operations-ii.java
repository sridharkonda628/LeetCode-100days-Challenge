import java.util.*;

class Solution {
    private int check(int[] nums, int n, int t, int m) {
        long arrLen = n;
        long totlLen = t;

        int lo = lwrBound(nums, arrLen);
        int hi = upBound(nums, arrLen);

        int ll = lwrBound(nums, arrLen - totlLen);
        int hh = upBound(nums, arrLen + totlLen);
        int res = (hh - hi) + (lo - ll);
        return Math.min(m, res) + (hi - lo);
    }

    private int lwrBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upBound(int[] arr, long target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target){
                left = mid + 1;
            } 
            else{
                right = mid;
            } 
        }
        return left;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int m = numOperations;
        Arrays.sort(nums);
        int maxFrequency = 1;


        for (int i = 0; i < nums.length - 1; i++) {
            maxFrequency = Math.max(maxFrequency, check(nums, nums[i], k, m));
            maxFrequency = Math.max(maxFrequency, check(nums, nums[i] - k, k, m));
            maxFrequency = Math.max(maxFrequency, check(nums, nums[i] + k, k, m));
        }

        return maxFrequency;
    }
}