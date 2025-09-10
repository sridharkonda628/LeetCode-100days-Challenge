class Solution {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> hset = new HashSet<>();


        for (int[] frdship : friendships) {
            Map<Integer, Integer> mp = new HashMap<>();
            boolean conm = false;
            for (int lan : languages[frdship[0] - 1]) {
                mp.put(lan, 1);
            }
            for (int lan : languages[frdship[1] - 1]) {
                if (mp.containsKey(lan)) {
                    conm = true;
                    break;
                }
            }
            if (!conm) {
                hset.add(frdship[0] - 1);
                hset.add(frdship[1] - 1);
            }
        }
        int maxiCnt = 0;
        int[] cnter = new int[n + 1];

        for (int friendship : hset) {
            for (int lan : languages[friendship]) {
                cnter[lan]++;
                maxiCnt = Math.max(maxiCnt, cnter[lan]);
            }
        }
        return hset.size() - maxiCnt;
    }
}