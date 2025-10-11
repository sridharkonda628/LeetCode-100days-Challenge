import java.util.*;

class Solution {
    long[] DpArray;
    List<long[]> arr;

    long solve(int i) {
        int n = arr.size();
        if (i >= n){
            return 0;
        }
        if (DpArray[i] != -1) {
            return DpArray[i];
        }
        long nTake = solve(i + 1);
        long take = arr.get(i)[1];
        int j = i + 1;
        while (j < n && arr.get(j)[0] - arr.get(i)[0] <= 2) j++;
        take += solve(j);
        return DpArray[i] = Math.max(take, nTake);
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> spellMap = new HashMap<>();

        for (int x : power) {
            spellMap.put(x, spellMap.getOrDefault(x, 0L) + x);
        }
        arr = new ArrayList<>();

        for (var edge : spellMap.entrySet()) {
            arr.add(new long[]{edge.getKey(), edge.getValue()});
        }

        arr.sort(Comparator.comparingLong(a -> a[0]));

        DpArray = new long[arr.size()];
        Arrays.fill(DpArray, -1);
        return solve(0);
    }
}