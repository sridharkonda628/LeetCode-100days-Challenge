class Solution {

    public int[] avoidFlood(int[] rains) {
        int[] avoidFloodAnswer = new int[rains.length];

        Arrays.fill(avoidFloodAnswer, 1);

        TreeSet<Integer> ordSetToTack = new TreeSet<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < rains.length; ++i) {
            if (rains[i] == 0) {
                //add to the ordered Set
                ordSetToTack.add(i);
            } else {
                //no drainage
                avoidFloodAnswer[i] = -1;
                if (mp.containsKey(rains[i])) {
                    Integer it = ordSetToTack.ceiling(mp.get(rains[i]));
                    // if nod such index is found, then there will be flooding
                    if (it == null) {
                        //so we return an empty array here
                        return new int[0];
                    }
                    // if index is found that indicates there is a possible to drain that particular idx day
                    avoidFloodAnswer[it] = rains[i];
                    
                    ordSetToTack.remove(it);
                }
                mp.put(rains[i], i);
            }
        }

        return avoidFloodAnswer;
    }
}